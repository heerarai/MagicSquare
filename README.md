# MagicSquare

Authors: Suhani Rai, Vishnu Saravanakumar

## Overview

A Java program that generates a magic square of any odd or double-even size and calculates sums of its diagonals, rows, and columns. 
A magic square is a square matrix of numbers where the sum of each row, column, and both main diagonals are equal.

___

## Features

- Supports odd-order and double-even-order magic squares.
- Generates the magic square automatically based on user input.
- Prints the magic square neatly with aligned columns.
- Displays sums of both diagonals.
- Displays sum of a specified row and column.
- Handles invalid input gracefully.

___

## How It Works

- Initialization: The program creates a 2D array (magicSquare) based on the user-specified size.
- Magic Square Generation:
  - Odd-sized squares: Uses the Siamese method (moving up-right, wrapping around edges).
  - Double-even squares: Fills corners, the middle section, and remaining values according to standard double-even algorithms.
- Output:
  - Prints the generated magic square.
  - Prints sums of both diagonals.
  - Prints sums of the user-specified row and column.
