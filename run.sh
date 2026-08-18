#!/usr/bin/env bash
# Launch the BYOW tile game.
# patched-stdlib must come first so our flicker-fixed StdDraw overrides the copy in algs4.jar.
set -euo pipefail
cd "$(dirname "$0")"
exec java -cp "patched-stdlib:.:algs4.jar" core.Main
