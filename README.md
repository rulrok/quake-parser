```text
  █████   █    ██  ▄▄▄       ██ ▄█▀▓█████     ██▓███   ▄▄▄       ██▀███    ██████ ▓█████  ██▀███  
▒██▓  ██▒ ██  ▓██▒▒████▄     ██▄█▒ ▓█   ▀    ▓██░  ██▒▒████▄    ▓██ ▒ ██▒▒██    ▒ ▓█   ▀ ▓██ ▒ ██▒
▒██▒  ██░▓██  ▒██░▒██  ▀█▄  ▓███▄░ ▒███      ▓██░ ██▓▒▒██  ▀█▄  ▓██ ░▄█ ▒░ ▓██▄   ▒███   ▓██ ░▄█ ▒
░██  █▀ ░▓▓█  ░██░░██▄▄▄▄██ ▓██ █▄ ▒▓█  ▄    ▒██▄█▓▒ ▒░██▄▄▄▄██ ▒██▀▀█▄    ▒   ██▒▒▓█  ▄ ▒██▀▀█▄  
░▒███▒█▄ ▒▒█████▓  ▓█   ▓██▒▒██▒ █▄░▒████▒   ▒██▒ ░  ░ ▓█   ▓██▒░██▓ ▒██▒▒██████▒▒░▒████▒░██▓ ▒██▒
░░ ▒▒░ ▒ ░▒▓▒ ▒ ▒  ▒▒   ▓▒█░▒ ▒▒ ▓▒░░ ▒░ ░   ▒▓▒░ ░  ░ ▒▒   ▓▒█░░ ▒▓ ░▒▓░▒ ▒▓▒ ▒ ░░░ ▒░ ░░ ▒▓ ░▒▓░
 ░ ▒░  ░ ░░▒░ ░ ░   ▒   ▒▒ ░░ ░▒ ▒░ ░ ░  ░   ░▒ ░       ▒   ▒▒ ░  ░▒ ░ ▒░░ ░▒  ░ ░ ░ ░  ░  ░▒ ░ ▒░
   ░   ░  ░░░ ░ ░   ░   ▒   ░ ░░ ░    ░      ░░         ░   ▒     ░░   ░ ░  ░  ░     ░     ░░   ░ 
    ░       ░           ░  ░░  ░      ░  ░                  ░  ░   ░           ░     ░  ░   ░     
```

# quake-parser

## Setup

Only the minimal setup is necessary to run the application.

For development, simply download the [JDK 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html).
No third-party libraries are necessary.

Just open the project with the last version of [Netbeans](https://netbeans.org/downloads/) and run it.

Once it is launched, the usage is totally straightforward. Use the only button to open the file and the results will be immediately displayed on the application textarea.

## Solution

The parser works reading each line of a text file and delegates it to a line parser to extract the relevant information.

Take for instance the line presented below:

`21:07 Kill: 1022 2 22: <world> killed Isgalamido by MOD_TRIGGER_HURT`

**Fields description**
 * 21:07 - Time occurrence
 * Kill: - The type of event described by the line
 * 1022: - The doer id of the action. In this special case, 1022 represents the special _<world>_ player
 * 2     - The receiver of the action. In this case, the player identified by the ID number 2
 * 22    - The used object by the doer of the action upon the receiver. In this case, MOD_TRIGGER_HURT
 
Due to this structure, the parser basically does a basic parse on the file to later delegate it to a specific line parser.

Therefore, each line can be viewed as a simple grammar structure, where:

  * The line action is the **verb** of the occurrence
  * The doer of the action is the **subject** of the line
  * The receiver of the action is the **direct object** of the line
  * The used object on the action if the **indirect object** of the line
  
Inside the package `quakeparser.lineparsers`, each class is responsible for one kind of log line, and it is their responsibility to determine
  the most appropriated **subject**, **direct object**, and **indirect object** of each line.
  
If the line _cannot_ be parsed by anyone of those parsers, a default `UNKNOWN` event is generated.

A `Line` object is generated for each parsed line. This object conforms to the `ILine` interface and can be  
digested by any other object which conforms to the `IGame` interface through the `addEvent(ILine event)` method.

The `Game` class is responsible for storing each meaningful information parsed by the line parser.

The `QuakeParser` class is responsible for getting a line from the log, obtain the parsed line through delegation, add it to a `Game` object, and verify if the game is finished.

## Parser robustness

Each line has to match the following **regular expression** to be considered a valid parsable quake log line:

```regex
"^\s*?\d+:\d+ \w+:.*$"
```

 * It allows some initial white-space at the beginning of the line (^\s*?),
 * followed by the minute digits followed by `:` and the second digits (\d+:\d+),
 * one single space separating the time and the event descriptor ( ),
 * the event name immediately followed by `:` (\w+:),
 * followed by anything that can or cannot by present.
 
 
Since each line _HAS_ to match this regex, you could try opening any file. It will be consumed line by line, 
yet if not line in the entire file is suitable for the parser, an empty results will be shown by the application but no error will be thrown.
