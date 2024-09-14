package com.rikcyolmedo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Hello world!
 */
import java.nio.file.Path;
import java.nio.file.Paths;

public class VideoUploader {
    private final static String QUEUE_NAME = "video_processing_queue";

    public static void main(String[] argv) throws Exception {
        // Absolute or relative path to the video file (adjust this to your file location)
        Path videoPath = Paths.get("/home/ricardo/Desktop/Vacuna_Estres.mp4");
        
        // Send the path of the video to RabbitMQ
        sendMessage(videoPath.toString());
    }

    public static void sendMessage(String message) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Uploaded and sent video path: '" + message + "'");
        }
    }
}
