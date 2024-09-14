package com.rikcyolmedo;

/**
 * Hello world!
 */
import com.rabbitmq.client.*;
import java.io.File;
import java.io.IOException;

public class ThumbnailExtractor {
    private final static String QUEUE_NAME = "video_processing_queue";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
             
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            System.out.println(" [*] Waiting for video upload messages...");
            
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String videoFilePath = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Received video file path: '" + videoFilePath + "'");
                
                // Call the method to extract the actual thumbnail
                extractThumbnail(videoFilePath);
            };
            
            channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {});
        }
    }

    private static void extractThumbnail(String videoFilePath) {
        // Define the output file for the thumbnail
        File thumbnail = new File("thumbnail.png");

        // FFmpeg command to extract a frame at the 5th second of the video
        String ffmpegCommand = "ffmpeg -i " + videoFilePath + " -ss 00:00:05 -vframes 1 " + thumbnail.getAbsolutePath();

        try {
            // Execute the FFmpeg command to extract the thumbnail
            Process process = Runtime.getRuntime().exec(ffmpegCommand);
            process.waitFor();  // Wait for the command to finish

            System.out.println(" [x] Thumbnail successfully extracted and saved as: " + thumbnail.getAbsolutePath());
        } catch (IOException | InterruptedException e) {
            System.err.println(" [!] Error extracting thumbnail: " + e.getMessage());
        }
    }
}
