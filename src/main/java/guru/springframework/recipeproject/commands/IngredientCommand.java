package guru.springframework.recipeproject.commands;

import guru.springframework.recipeproject.domain.UnitOfMeasure;

import java.math.BigDecimal;

public class IngredientCommand {
    private Long id;
    private String description;
    private BigDecimal amount;
    private UnitOfMeasure unitOfMeasure;
}
