package mxkcpy.badreads.data;

public final class BookEnums {

    BookEnums() {
        throw new IllegalStateException("Utility class");
    }

    public enum Genre {
        FICTION,
        HISTORICAL_FICTION,
        ROMANCE,
        HISTORICAL,
        THRILLER,
        NOVEL,
        SELF_HELP,
    }

    public enum CoverType {
        HARD_COVER,
        SOFT_COVER,
        EBOOK
    }

    public enum Publisher {
        MACMILLAN,
    }
}
