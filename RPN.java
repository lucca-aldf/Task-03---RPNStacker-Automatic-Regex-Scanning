import java.io.*;
import java.util.*;


class RPN{

    public static void main(String[] args) throws Exception{
        File inputFile = new File("input.txt");
        boolean validInput = true;
        Scanner inputReader = new Scanner(inputFile);
        Stack<Token> stack = new Stack<Token>();
        LinkedList<Token> inputHolder = new LinkedList<Token>();

        while (inputReader.hasNextLine() && validInput) {
            String inputText = inputReader.nextLine().strip();
            Token token = new Token(inputText);

            inputHolder.add(token);
            
            if (validInput && (token.type.equals(TokenType.PLUS) || token.type.equals(TokenType.MINUS) || token.type.equals(TokenType.STAR) || token.type.equals(TokenType.SLASH))){
              int value1 = Integer.parseInt(stack.pop().lexeme);
              int value0 = Integer.parseInt(stack.pop().lexeme);
              
              if (token.type.equals(TokenType.PLUS)) {
                stack.push(new Token(String.valueOf(value0 + value1)));
              }
            }

            else if (validInput) {
              stack.push(token);
            }
        }

        if (validInput) {
          while (!inputHolder.isEmpty()) {
              System.out.println(inputHolder.getFirst());
              inputHolder.removeFirst();
          }

          System.out.println();
          System.out.print("Saida: "); System.out.print(stack.pop());

        }

    };
}