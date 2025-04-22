import java.io.*;

class WriterThread extends Thread {
    private PipedOutputStream outputStream;

    public WriterThread(PipedOutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void run() {
        try {
            String message = "Hello from Writer Thread!";
            outputStream.write(message.getBytes());
            outputStream.close();
        } catch (IOException e) {
            System.out.println("Error writing data: " + e.getMessage());
        }
    }
}

class ReaderThread extends Thread {
    private PipedInputStream inputStream;

    public ReaderThread(PipedInputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void run() {
        try {
            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            System.out.println("Received: " + new String(buffer, 0, bytesRead));
            inputStream.close();
        } catch (IOException e) {
            System.out.println("Error reading data: " + e.getMessage());
        }
    }
}

public class PipedStreamCommunication {
    public static void main(String[] args) {
        try {
            PipedOutputStream outputStream = new PipedOutputStream();
            PipedInputStream inputStream = new PipedInputStream(outputStream);

            WriterThread writer = new WriterThread(outputStream);
            ReaderThread reader = new ReaderThread(inputStream);

            writer.start();
            reader.start();
        } catch (IOException e) {
            System.out.println("Error setting up Piped Streams: " + e.getMessage());
        }
    }
}