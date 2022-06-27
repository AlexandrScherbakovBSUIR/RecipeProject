package guru.springframework.recipeproject.commands;

public class RecipeNoteCommand {
    private Long id;
    private String recipeNoteCommand;

    public RecipeNoteCommand() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecipeNoteCommand() {
        return recipeNoteCommand;
    }

    public void setRecipeNoteCommand(String recipeNoteCommand) {
        this.recipeNoteCommand = recipeNoteCommand;
    }
}
