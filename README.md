# BYOW — Build Your Own World

A 2D tile-based world exploration game built on Princeton's `algs4` standard libraries.
Worlds are rendered with a custom tile engine, and the display uses a flicker-fixed
version of `StdDraw` for smooth, per-frame updates.

## Requirements

- Java (JDK 8 or newer) with `java` on your `PATH`

## Running

```bash
./run.sh
```

This launches `core.Main`. The classpath is ordered so that the patched, flicker-fixed
`StdDraw` in `patched-stdlib/` takes precedence over the copy bundled in `algs4.jar`.

To run manually:

```bash
java -cp "patched-stdlib:.:algs4.jar" core.Main
```

## Project layout

| Path              | Description                                                        |
| ----------------- | ------------------------------------------------------------------ |
| `core/`           | Game logic — `Main`, `World`, and `Room`.                          |
| `tileengine/`     | Tile rendering — `TERenderer`, `TETile`, and `Tileset`.            |
| `utils/`          | Helpers — `RandomUtils` and `FileUtils`.                           |
| `patched-stdlib/` | Flicker-fixed `StdDraw` that overrides the version in `algs4.jar`. |
| `algs4.jar`       | Princeton `algs4` standard libraries.                              |
| `run.sh`          | Launch script with the correct classpath ordering.                 |
| `save.txt`        | Runtime save-game state (git-ignored).                             |

## Notes

The patched `StdDraw` fixes per-frame screen flashing by avoiding a full clear on every
frame, so the game renders smoothly during play.
