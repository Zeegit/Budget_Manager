package budget;

public enum Category {
    FOOD("Food"),
    CLOTHES("Clothes"),
    ENTERTAIMENT("Entertainment"),
    OTHER("Other");

    private String categoryName;

    Category(String categoryName) {
        this.categoryName = categoryName;
    }

    String getName() {
        return categoryName;
    }
}
