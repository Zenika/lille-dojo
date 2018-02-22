package test.java

import main.java.*
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.Ignore
import org.junit.Test

/**
 * Created by zenika on 22/02/18.
 */
class GameOfLifeTest {

    fun createOverpopulatedGrid(): Grid {
        val len = 3
        return Array(len, { BooleanArray(len, { true }) })
    }

    fun createGrid() : Grid {
        val len = 3
        val grid = Array(len, { BooleanArray(len, { false }) })
        grid[1][1] = true
        return grid
    }

    fun createGreatGrid() : Grid {
        val len = 4
        val grid = Array(len, { BooleanArray(len, { false }) })
        grid[1][1] = true
        grid[1][2] = true
        grid[1][3] = true
        return grid
    }

    fun createGridAfterOneTurn() : Grid {
       return Array(3, { BooleanArray(3, { false }) })
    }

    @Test
    fun `should return the grid unchanged`() {
        assertThat(gameOfLife(createGrid(), 0)).isEqualTo(createGrid())
    }

    @Test
    fun `should kill one cell of underpopulation`() {
        assertThat(gameOfLife(createGrid(), 1)).isEqualTo(createGridAfterOneTurn())
    }

    @Test
    fun `should return number of alive neighbours`() {
        assertThat(countAliveNeighbours(0 to 1, createGrid())).isEqualTo(1)

    }

    @Test
    fun `should return number of alive neighbours2`() {
        assertThat(countAliveNeighbours(0 to 2, createGrid())).isEqualTo(1)
    }

    @Test
    fun `should return the next state of a cell`() {
        assertThat(nextCellState(1 to 1, createGrid())).isFalse()
    }

    @Test
    fun `should kill one cell of overpopulation`() {
        assertThat(gameOfLife(createOverpopulatedGrid(), 1)[1][1]).isFalse()
    }

    @Test
    fun `should handle grid of 42 columns and 42 rows`() {
        val grid = createGreatGrid()
        assertThat(gameOfLife(grid, 1)[1][2]).isTrue()
    }
}