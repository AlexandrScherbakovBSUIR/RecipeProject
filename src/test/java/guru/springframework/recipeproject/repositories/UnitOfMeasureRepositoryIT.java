package guru.springframework.recipeproject.repositories;

import guru.springframework.recipeproject.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class UnitOfMeasureRepositoryIT {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    @DirtiesContext
    void findByDescriptionSpoon() {

        UnitOfMeasure unitOfMeasure = unitOfMeasureRepository.findByDescription("Teaspoon");

        assertEquals("Teaspoon",unitOfMeasure.getDescription());

    }

    @Test
    void findByDescriptionPiece() {

        UnitOfMeasure unitOfMeasure = unitOfMeasureRepository.findByDescription("Piece");

        assertEquals("Piece",unitOfMeasure.getDescription());

    }
}