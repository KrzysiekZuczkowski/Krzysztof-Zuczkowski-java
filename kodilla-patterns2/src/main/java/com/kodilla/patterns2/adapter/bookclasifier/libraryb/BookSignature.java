package com.kodilla.patterns2.adapter.bookclasifier.libraryb;

public class BookSignature {

    private final String signature;

    public BookSignature(final String signature) {
        this.signature = signature;
    }

    public String getSignature() {
        return signature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookSignature)) return false;

        BookSignature that = (BookSignature) o;

        return getSignature() != null ? getSignature().equals(that.getSignature()) : that.getSignature() == null;
    }

    @Override
    public int hashCode() {
        return getSignature() != null ? getSignature().hashCode() : 0;
    }
}
