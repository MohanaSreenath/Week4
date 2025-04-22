import java.io.*;

public class ImageByteArrayConversion {

    public static byte[] convertImageToByteArray(String imagePath) {
        try (FileInputStream fis = new FileInputStream(imagePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            System.out.println("Error reading image file: " + e.getMessage());
        }
        return new byte[0];
    }

    public static void writeByteArrayToImage(byte[] imageBytes, String newImagePath) {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(newImagePath)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            System.out.println("New image file created successfully.");
        } catch (IOException e) {
            System.out.println("Error writing image file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String originalImage = "original_image.jpg";
        String copiedImage = "copied_image.jpg";

        byte[] imageBytes = convertImageToByteArray(originalImage);
        if (imageBytes.length > 0) {
            writeByteArrayToImage(imageBytes, copiedImage);
        }
    }
}