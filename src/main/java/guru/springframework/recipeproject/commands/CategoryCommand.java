package guru.springframework.recipeproject.commands;

public class CategoryCommand {
    private Long id;
    private String description;

    public CategoryCommand() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CategoryCommand{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
