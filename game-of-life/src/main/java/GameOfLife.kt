package main.java

/**
 * Created by zenika on 22/02/18.
 * Rules:
 *    1. Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
 *    2. Any live cell with more than three live neighbours dies, as if by overcrowding.
 *    3. Any live cell with two or three live neighbours lives on to the next generation.
 *    4. Any dead cell with exactly three live neighbours becomes a live cell.
 */

typealias Grid = Array<BooleanArray>
typealias Coord = Pair<Int, Int>

fun main(args: Array<String>) {
    println("It works")
}

fun gameOfLife(grid: Grid, nbTurns: Int): Grid {
    if (nbTurns == 0 ) {
        return grid
    }

    return gameOfLife(nextGridState(grid), nbTurns - 1)
}

fun nextGridState(grid: Grid): Grid {
    val nextGrid = grid.clone().map { it.clone() }.toTypedArray()

    for(x in 0 until grid.size) {
        for(y in 0 until grid.size) {
            nextGrid[x][y] = nextCellState(x to y, grid)
        }
    }

    return nextGrid
}

fun nextCellState(coord: Coord, grid: Grid): Boolean {
    val aliveNeighboursCount = countAliveNeighbours(coord, grid)
    return aliveNeighboursCount == 3 ||
            (grid[coord.first][coord.second] && aliveNeighboursCount == 2)
}


fun countAliveNeighbours(coord: Coord, grid: Grid): Int{
    var indexes : Array<Coord> = Array(3*3, {0 to 0})

    for (x in 0 .. 2) {
        for (y in 0 .. 2) {
            indexes[x*3+y] = (coord.first + x - 1) to (coord.second + y - 1)
        }
    }

    return indexes
            .filterNot { it.equals(coord) }
            .filter { grid.hasPoint(it) }
            .map { grid[it.first][it.second] }
            .count { it }
}

fun Grid.hasPoint(coords: Coord) = coords.first in 0 until this.size
                                                && coords.second in 0 until this.size

