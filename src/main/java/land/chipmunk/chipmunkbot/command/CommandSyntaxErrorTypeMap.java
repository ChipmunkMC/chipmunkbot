package land.chipmunk.chipmunkbot.command;

import com.mojang.brigadier.Message;
import com.mojang.brigadier.exceptions.BuiltInExceptionProvider;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.CommandExceptionType;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.exceptions.Dynamic2CommandExceptionType; 
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import net.kyori.adventure.text.TextComponent;

import java.util.Map;
import java.util.HashMap;

public class CommandSyntaxErrorTypeMap {
  private CommandSyntaxErrorTypeMap () {
  }

  // Just some methods for stuff repeated a lot
  private static Message message (final String key, final ComponentLike... args) { return ComponentMessage.wrap(Component.translatable(key, args)); } 
  private static TextComponent text (final Object text) { return Component.text(String.valueOf(text)); }
  private static TextComponent text (final int text) { return Component.text(text); }
  private static TextComponent text (final char text) { return Component.text(String.valueOf(text)); }

  public static Map<CommandExceptionType, CommandExceptionType> map = new HashMap<>();

  static {
    final BuiltInExceptionProvider builtIn = CommandSyntaxException.BUILT_IN_EXCEPTIONS;

    map.put(builtIn.doubleTooLow(), new Dynamic2CommandExceptionType((found, min) -> message("argument.double.low", text(min), text(found))));
    map.put(builtIn.doubleTooHigh(), new Dynamic2CommandExceptionType((found, max) -> message("argument.double.big", text(max), text(found))));

    map.put(builtIn.floatTooLow(), new Dynamic2CommandExceptionType((found, min) -> message("argument.float.low", text(min), text(found))));
    map.put(builtIn.floatTooHigh(), new Dynamic2CommandExceptionType((found, max) -> message("argument.float.big", text(max), text(found))));

    map.put(builtIn.integerTooLow(), new Dynamic2CommandExceptionType((found, min) -> message("argument.integer.low", text(min), text(found))));
    map.put(builtIn.integerTooHigh(), new Dynamic2CommandExceptionType((found, max) -> message("argument.integer.big", text(max), text(found))));

    map.put(builtIn.longTooLow(), new Dynamic2CommandExceptionType((found, min) -> message("argument.long.low", text(min), text(found))));
    map.put(builtIn.longTooHigh(), new Dynamic2CommandExceptionType((found, max) -> message("argument.long.big", text(max), text(found))));

    map.put(builtIn.literalIncorrect(), new DynamicCommandExceptionType(expected -> message("argument.literal.incorrect", text(expected))));

    map.put(builtIn.readerExpectedStartOfQuote(), new SimpleCommandExceptionType(message("parsing.quote.expected.start")));
    map.put(builtIn.readerExpectedEndOfQuote(), new SimpleCommandExceptionType(message("parsing.quote.expected.end")));
    map.put(builtIn.readerInvalidEscape(), new DynamicCommandExceptionType(character -> message("parsing.quote.escape", text(character))));
    map.put(builtIn.readerInvalidBool(), new DynamicCommandExceptionType(value -> message("parsing.bool.invalid", text(value))));
    map.put(builtIn.readerInvalidInt(), new DynamicCommandExceptionType(value -> message("parsing.int.invalid", text(value))));
    map.put(builtIn.readerExpectedInt(), new SimpleCommandExceptionType(message("parsing.int.expected")));
    map.put(builtIn.readerInvalidLong(), new DynamicCommandExceptionType(value -> message("parsing.long.invalid", text(value))));
    map.put(builtIn.readerExpectedLong(), new SimpleCommandExceptionType(message("parsing.long.expected")));
    map.put(builtIn.readerInvalidDouble(), new DynamicCommandExceptionType(value -> message("parsing.double.invalid", text(value))));
    map.put(builtIn.readerExpectedDouble(), new SimpleCommandExceptionType(message("parsing.double.expected")));
    map.put(builtIn.readerInvalidFloat(), new DynamicCommandExceptionType(value -> message("parsing.float.invalid", text(value))));
    map.put(builtIn.readerExpectedFloat(), new SimpleCommandExceptionType(message("parsing.float.expected")));
    map.put(builtIn.readerExpectedBool(), new SimpleCommandExceptionType(message("parsing.bool.expected")));
    map.put(builtIn.readerExpectedSymbol(), new DynamicCommandExceptionType(symbol -> message("parsing.expected", text(symbol))));

    map.put(builtIn.dispatcherUnknownCommand(), new SimpleCommandExceptionType(message("command.unknown.command")));
    map.put(builtIn.dispatcherUnknownArgument(), new SimpleCommandExceptionType(message("command.unknown.argument")));
    map.put(builtIn.dispatcherExpectedArgumentSeparator(), new SimpleCommandExceptionType(message("command.expected.separator")));
    map.put(builtIn.dispatcherParseException(), new SimpleCommandExceptionType(message("command.exception")));
  }
}
