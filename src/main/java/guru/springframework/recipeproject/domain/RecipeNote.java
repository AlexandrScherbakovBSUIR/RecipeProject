package guru.springframework.recipeproject.domain;

import javax.persistence.*;

@Entity
public class RecipeNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recipe recipe;

    @Lob
    private String resiceNote;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public String getResiceNote() {
        return resiceNote;
    }

    public void setResiceNote(String resiceNote) {
        this.resiceNote = resiceNote;
    }
}
