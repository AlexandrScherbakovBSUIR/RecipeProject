package guru.springframework.recipeproject.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer serving;
    private String source;
    private String url;
    private String directions;

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @Lob
    private Byte[] image;

    @OneToOne(cascade = CascadeType.ALL)
    private RecipeNote recipeNote;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "recipe")
    private Set<Ingredient> ingredients;

    @ManyToMany
    @JoinTable(name = "recipe_category",
        joinColumns =  @JoinColumn (name = "recipe_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    public Recipe() {
    }


    public void setRecipeNote(RecipeNote recipeNote) {
        this.recipeNote = recipeNote;
        recipeNote.setRecipe(this);
    }
    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
        for (Ingredient ingredient : this.ingredients) {
            ingredient.setRecipe(this);

        }
    }


    public Long getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public Integer getPrepTime() {
        return this.prepTime;
    }

    public Integer getCookTime() {
        return this.cookTime;
    }

    public Integer getServing() {
        return this.serving;
    }

    public String getSource() {
        return this.source;
    }

    public String getUrl() {
        return this.url;
    }

    public String getDirections() {
        return this.directions;
    }

    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    public Byte[] getImage() {
        return this.image;
    }

    public RecipeNote getRecipeNote() {
        return this.recipeNote;
    }

    public Set<Ingredient> getIngredients() {
        return this.ingredients;
    }

    public Set<Category> getCategories() {
        return this.categories;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public void setServing(Integer serving) {
        this.serving = serving;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public String toString() {
        return "Recipe(id=" + this.getId() + ", description=" + this.getDescription() + ", prepTime=" + this.getPrepTime() + ", cookTime=" + this.getCookTime() + ", serving=" + this.getServing() + ", source=" + this.getSource() + ", url=" + this.getUrl() + ", directions=" + this.getDirections() + ", difficulty=" + this.getDifficulty() + ", image=" + java.util.Arrays.deepToString(this.getImage()) + ", recipeNote=" + this.getRecipeNote() + ", ingredients=" + this.getIngredients() + ", categories=" + this.getCategories() + ")";
    }
}
