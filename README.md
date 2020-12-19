# vscode-playground

NOT YET FULLY IMPLEMENTED

📚 Learning and exploring Visual Studio Code <https://code.visualstudio.com/>.

## Notes

With this repository I am trying out Visual Studio Code in detail. Before, I have only used it for basic text editing
but I would like to explore its many other features like [VS Code Remote Development](https://code.visualstudio.com/docs/remote/remote-overview)
and its support for Java development, especially for simple Java programs that have no or minimal dependencies and does
not abide by the conventional (and verbose) `src/main/java/...` file structure. How simple can a Java project be? How
lightweight can it be? Let's find out with Visual Studio Code! (To be fair, I still love Intellij.)

## Observations about Visual Studio Code

* I like VS Code's "launch configurations" (an analog to Intellij's "run configurations") for two reasons. 1) they are
  defined in JSON (and ostensibly I should version control them in Git?) and 2) they simply kick off a command in the
  in-app terminal. It's a very simple model! By contrast, Intellij executes a run configuration in a separate "Run"
  window. While this isn't a major difference, the VS Code model is delightfully "obvious".