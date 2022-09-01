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
    private String recipeNote;


    public RecipeNote() {
    }

    public Long getId() {
        if (this.id==null){
            return 666L;
        }
        return this.id;
    }

    public Recipe getRecipe() {
        return this.recipe;
    }

    public String getRecipeNote() {
        return this.recipeNote;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public void setRecipeNote(String recipeNote) {
        this.recipeNote = recipeNote;
    }

    public String toString() {
        return "RecipeNote(id=" + this.getId() + ", recipeId=" + this.getRecipe().getId() + ", recipeNote=" + this.getRecipeNote() + ")";
    }
}
