package guru.springframework.recipeproject.commands;

public class RecipeNoteCommand {
    private Long id;
    private String recipeNote;

    public RecipeNoteCommand() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecipeNote() {
        return recipeNote;
    }

    public void setRecipeNote(String recipeNote) {
        this.recipeNote = recipeNote;
    }
}
