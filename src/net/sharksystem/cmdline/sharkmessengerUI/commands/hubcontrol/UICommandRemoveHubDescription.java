package net.sharksystem.cmdline.sharkmessengerUI.commands.hubcontrol;

import net.sharksystem.cmdline.sharkmessengerUI.*;
import net.sharksystem.hub.peerside.HubConnectorDescription;
import net.sharksystem.cmdline.sharkmessengerUI.SharkMessengerUI;

public class UICommandRemoveHubDescription extends UICommand {
    private UICommandIntegerArgument hubIndex;

    public UICommandRemoveHubDescription(SharkMessengerApp sharkMessengerApp, SharkMessengerUI sharkMessengerUI,
                                         String identifier, boolean rememberCommand) {
        super(sharkMessengerApp, sharkMessengerUI, identifier, rememberCommand);
        this.hubIndex = new UICommandIntegerArgument(sharkMessengerApp);
    }

    @Override
    protected UICommandQuestionnaire specifyCommandStructure() {
        return new UICommandQuestionnaireBuilder()
                .addQuestion("index in hub list (produced by lsHubs)? ", this.hubIndex)
                .build();
    }

    @Override
    protected void execute() throws Exception {
        HubConnectorDescription hubDescription =
                this.getSharkMessengerApp().getSharkPeer().getHubDescription(this.hubIndex.getValue());

        this.getSharkMessengerUI().getOutStream().println("remove hub description");
        HubDescriptionPrinter.print(this.getSharkMessengerUI().getOutStream(), hubDescription);

        this.getSharkMessengerApp().getSharkPeer().removeHubDescription(hubDescription);
    }

    @Override
    public String getDescription() {
        return "remove hub description from list";
    }
}
