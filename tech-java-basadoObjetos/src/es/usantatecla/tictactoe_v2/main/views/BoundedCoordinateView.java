package es.usantatecla.tictactoe_v2.main.views;

import es.usantatecla.tictactoe_v2.main.models.BoundedCoordinate;
import es.usantatecla.tictactoe_v2.main.models.Message;
import es.usantatecla.tictactoe_v2.main.models.Error;
import es.usantatecla.tictactoe_v2.utils.BoundedIntDialog;
import es.usantatecla.tictactoe_v2.utils.Console;

public class BoundedCoordinateView {

    private BoundedCoordinate boundedCoordinate;

    public BoundedCoordinateView(BoundedCoordinate boundedCoordinate) {
        this.boundedCoordinate = boundedCoordinate;
    }

    public void read(String title) {
        BoundedIntDialog boundedIntDialog = new BoundedIntDialog(1, BoundedCoordinate.getDimension());
        new Console().writeln(title);
        this.boundedCoordinate.setRow(boundedIntDialog.read(Message.ROW.toString()) - 1);
        this.boundedCoordinate.setColumn(boundedIntDialog.read(Message.COLUMN.toString()) - 1);

    }

    public String getErrorMessage() {
        return Error.WRONG_COORDINATES.toString();
    }
}
