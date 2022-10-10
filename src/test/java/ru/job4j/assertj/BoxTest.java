package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name)
                .isNotEmpty()
                .isNotNull()
                .isEqualTo("Sphere");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 10);
        String name = box.whatsThis();
        assertThat(name)
                .isNotEmpty()
                .isNotNull()
                .isEqualTo("Tetrahedron");
    }

    @Test
    void vertexShouldBe0() {
        Box box = new Box(0, 10);
        assertThat(box.getNumberOfVertices())
                .isEqualTo(0);
    }

    @Test
    void vertexShouldBe4() {
        Box box = new Box(4, 10);
        assertThat(box.getNumberOfVertices())
                .isGreaterThan(0)
                .isEqualTo(4);
    }

    @Test
    void isExist() {
        Box box = new Box(4, 10);
        assertThat(box.isExist()).isTrue();
    }

    @Test
    void isNotExist() {
        Box box = new Box(-1, 10);
        assertThat(box.isExist()).isFalse();
    }

    @Test
    void areaIs0() {
        Box box = new Box(-1, 10);
        assertThat(box.getArea())
                .isNotNull()
                .isEqualTo(0);
    }

    @Test
    void areaIsNot0() {
        Box box = new Box(4, 10);
        assertThat(box.getArea())
                .isNotNull()
                .isNotEqualTo(0)
                .isGreaterThan(0)
                .isCloseTo(173.205, withPrecision(0.001));
    }
}