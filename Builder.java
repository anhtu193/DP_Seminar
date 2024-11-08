class Book {
    // Tác giả viết ra cuốn sách
    String title;
    String author;
    String category;

    // Cuốn sách được gửi đến nhà máy
    String paper;
    String ink;
    String cover;

    public static builder() {
        return new BookBuilder();
    }

    public Book(BookBuilder builder) {
        return Book(builder.title, builder.author, builder.category, builder.paper, builder.ink, builder.cover);
    }

    public static class BookBuilder {
        String title;
        String author;
        String category;
        String paper;
        String ink;
        String cover;

        public BookBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public BookBuilder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public BookBuilder setCategory(String category) {
            this.category = category;
            return this;
        }

        public BookBuilder setPaper(String paper) {
            this.paper = paper;
            return this;
        }

        public BookBuilder setInk(String ink) {
            this.ink = ink;
            return this;
        }

        public BookBuilder setCover(String cover) {
            this.cover = cover;
            return this;
        }

        public BookBuilder writeBook(BookBuilder builder) {
            builder.setTitle("Tôi thấy hoa vàng trên cỏ xanh")
            .setAuthor("Nguyễn Nhật Ánh")
            .setCategory("Truyện ngắn")
            return builder;
        }

        public BookBuilder releaseBook(BookBuilder builder) {
            builder.setPaper("Giấy mỹ thuật")
            .setInk("Mực đen")
            .setCover("Bìa mềm")
            return builder;
        }

        public Book build() {
            return Book(this);
        }
    }

}

pubic static void main(String[] args) {
    BookBuilder builder = Book.builder();

    // Tác giả viết cuốn sách
    builder = writeBook(builder);

    // Cuốn sách được gửi đến nhà máy
    builder = releaseBook(builder);

    Book book = builder.build();
}