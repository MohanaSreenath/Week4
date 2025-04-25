class Book {
    private String title;
    private String author;
    private String genre;
    private double rating;

    public Book(String title, String author, String genre, double rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
    }

    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public double getRating() { return rating; }

    public String toString() { return title + " - Rating: " + rating; }
}

public class BookRecommendations {
    public static void main(String[] args) {
        List<Book> books = List.of(
                new Book("Dune", "Frank Herbert", "Science Fiction", 4.5),
                new Book("Foundation", "Isaac Asimov", "Science Fiction", 4.2),
                new Book("1984", "George Orwell", "Dystopian", 4.8),
                new Book("Neuromancer", "William Gibson", "Science Fiction", 4.1),
                new Book("Brave New World", "Aldous Huxley", "Science Fiction", 3.9)
        );

        List<Book> recommendedBooks = books.stream()
                .filter(b -> b.getGenre().equals("Science Fiction") && b.getRating() > 4.0)
                .sorted(Comparator.comparingDouble(Book::getRating).reversed())
                .limit(10)
                .collect(Collectors.toList());

        System.out.println("Top Science Fiction Books:");
        recommendedBooks.forEach(System.out::println);
    }
}
