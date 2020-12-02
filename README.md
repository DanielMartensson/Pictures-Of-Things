# Pictures Of Things

A collection of my own pictures in `416x416` format. All help is grateful.

# How to contribute to this repository

1. Download `Darknet Data Creator` and run it with `mvn javafx:run` https://github.com/DanielMartensson/Darknet-Data-Creator
2. Set picture resolution to `416x416`
3. Set sample time to `2.00` seconds
4. Select the class `ID` that you want to use e.g `0` for `cup` or a new class
5. Clone this repository with `git` command
6. Select `Classes` folder in `Darknet Data Creator` and begin to record. Don't select any folder that have a number e.g `15`. Only `Classes` folder.

Then `Darknet Data Creator` will count how many `.png` files there are inside the folder that has the
same `class ID` as you selected. When you press record, then `Darknet Data Creator` will begin to record 
and save pictures and begin counting from the last index.

Do then a pull request to me. Don't forget to change the `README.md` and `classes.names` files.

# Create list with paths 

`Darknet` want two lists of paths that contains paths to the pictures. Both in training and validation.
Here just run this `Java program`, where 0.8 will result 80% training and 20% validation paths. You can have a decimal number
between `0.0` and `1.0`:

```
java GeneratePaths 0.8
```

If you want to modify `GeneratePaths` and recompile it:

```
javac GeneratePaths
```

# Classes

* 0 = cup
* 1 = box