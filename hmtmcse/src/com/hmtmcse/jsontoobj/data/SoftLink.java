package com.hmtmcse.jsontoobj.data;

/**
 * Created by touhid on 3/01/2017.
 */
public class SoftLink {

    Link link;
    Move move;
    Delete delete;
    Boolean isFile = false;

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }

    public Delete getDelete() {
        return delete;
    }

    public void setDelete(Delete delete) {
        this.delete = delete;
    }

    public Boolean getIsFile() {
        return isFile;
    }

    public void setIsFile(Boolean file) {
        isFile = file;
    }
}
