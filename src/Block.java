class Block {
    private String hash;
    private String previousHash;
    private String transaction;

    Block(String hash, String previousHash, String transaction){
        this.hash = hash;
        this.previousHash = previousHash;
        this.transaction = transaction;
    }

    String getHash(){
        return this.hash;
    }

    String getPreviousHash(){
        return this.previousHash;
    }

    String getTransaction(){
        return this.transaction;
    }
}
