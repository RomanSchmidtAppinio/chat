package chat.client;

import chat.Uid;
import chat.communication.Communicator;
import chat.message.MessageContainer;
import chat.routing.Routing;

public abstract class AClient implements Actor {
    protected final String _name;
    protected final Uid _uid;

    AClient(Uid uid, String name) {
        this._uid = uid;
        this._name = name;
    }

    public Uid getUid() {
        return this._uid;
    }

    public String getName() {
        return this._name;
    }

    public void sendMessage(MessageContainer message) {
        System.out.println("sending message to server: " + message.getMessage().getHeader().getUidReceiver() + " (" + message.getMessage().getHeader().getUidReceiver() + ")");
        Communicator.send(message);
    }

    public void disconnect(boolean populate) {
        Routing.getInstance().removeClient(this, populate);
    }
}
