package main.es.pbover.connect4Old.models;

public interface PlayerVisitor {
    void visit(HumanPlayer humanPlayer);

    void visit(RandomPlayer randomPlayer);

    void visit(MinMaxPlayer minMaxPlayer);
}
