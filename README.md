# terjol

motherfucking terjol what the fuck

***

TerJol is a port of [TerCol](https://github.com/Butterroach/tercol) for Java.

THIS IS MY 3RD EVER JAVA THING GOD PLEASE SPARE ME

## Code example

```java
import terjol.terjol;

public class Main {
    public static void main(String[] args) {
        System.out.println(terjol.red("Red text"));
        System.out.println(terjol.blue("Blue text"));
        System.out.println(terjol.rgb(255, 215, 0, "Gold text using RGB"));
        System.out.println(terjol.dec(0xFFD700, "Gold text using HEX"));
        System.out.println(terjol.hsv(51, 100, 100, "Gold text using HSV"));
        System.out.println(terjol.rainbowtext("Rainbow text"));
    }
}
```

## How to use

1. Get the terjol.java file in src/terjol.
2. Run `javac terjol.java`.
3. Put the new `terjol.class` file in a directory named `terjol` in the same directory as your Java program.
4. You should be able to import it in your code using `import terjol.terjol` now!

## Differences:

- No aliases at all
- No `hexa`/`bghexa` function, but there is a `dec`/`bgdec` function that only takes integers (you can use `0x` followed by your hex code without any quotes to use HEX codes as shown in the code example)
- `bgrainbowtext` function that doesn't exist in the original TerCol


If it doesn't work then try using JDK 21. If that doesn't work I'm probably just stupid (open an issue or fix it for me and open a PR :3 :3 :3 pls fix it for me i am so clueless). 
