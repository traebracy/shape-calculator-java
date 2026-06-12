# Shape Calculator

A Java application that calculates area and perimeter for multiple shape types, then visualizes the selected shape with JavaFX.

The program asks the user for a number of sides, builds the correct shape object, collects the required measurements, prints the result, and opens a visual representation when JavaFX is available.

## Features

- Supports circles, triangles, rectangles, pentagons, and generic polygons
- Uses a shared `Shape` abstraction for common behavior
- Uses `Polygon` as a base class for polygon-based shapes
- Calculates area and perimeter for each supported shape
- Validates triangle side lengths and angle totals
- Uses JavaFX to draw the selected shape

## Concepts Practiced

- Java
- Object-oriented programming
- Abstract classes
- Inheritance
- Polymorphism
- Method overriding
- Switch expressions
- JavaFX graphics

## How to Run

Compile the Java files:

```bash
javac *.java
```

Run the main program:

```bash
java Main
```

JavaFX must be configured in your IDE or runtime environment for the visualizer window to display correctly.

## What I Learned

This project helped me understand how class hierarchies can model real-world categories. A circle, triangle, rectangle, and polygon all share shape behavior, but each one calculates its measurements differently.