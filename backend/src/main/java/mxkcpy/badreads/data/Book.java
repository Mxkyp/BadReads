package mxkcpy.badreads.data;

import java.util.List;

public record Book(int id, Author author, Metadata metadata)
{

    public record Author(String Name, String Surname) { }
    public record Metadata(String isbn13, String isbn10, String title,
                           String subtitle, List<String> genres,
                           String thumbnailURL, String description,
                           String publishedYear, double averageRating, int pageNumber) { }
}
