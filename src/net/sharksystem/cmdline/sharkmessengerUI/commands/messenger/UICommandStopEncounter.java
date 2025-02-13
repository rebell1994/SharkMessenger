package net.sharksystem.cmdline.sharkmessengerUI.commands.messenger;

import net.sharksystem.cmdline.sharkmessengerUI.*;
import net.sharksystem.cmdline.sharkmessengerUI.SharkMessengerUI;

@Deprecated
public class UICommandStopEncounter extends UICommand {

    private final UICommandKnownPeerArgument peer1;
    private final UICommandKnownPeerArgument peer2;

    public UICommandStopEncounter(SharkMessengerApp sharkMessengerApp, SharkMessengerUI sharkMessengerUI,
                                  String identifier, boolean rememberCommand) {
        super(sharkMessengerApp, sharkMessengerUI, identifier, rememberCommand);
        this.peer1 = new UICommandKnownPeerArgument(sharkMessengerApp);
        this.peer2 = new UICommandKnownPeerArgument(sharkMessengerApp);
    }

    @Override
    public UICommandQuestionnaire specifyCommandStructure() {
        return new UICommandQuestionnaireBuilder().
                addQuestion("First peer name: ", this.peer1).
                addQuestion("Second peer name: ", this.peer2).
                build();
    }

    @Override
    public void execute() throws Exception {
        //try {
            //this.peer1.getValue().getASAPTestPeerFS().stopEncounter(this.peer2.getValue().getASAPTestPeerFS());
        //} catch (SharkException | IOException e) {
         //   ui.printError(e.getLocalizedMessage());
        //
    }

    @Override
    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stops an already running encounter.");
        return sb.toString();
    }

}
