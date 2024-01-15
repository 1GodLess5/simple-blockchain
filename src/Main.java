import java.util.ArrayList;
import com.google.gson.GsonBuilder;
public class Main {
    private static ArrayList<Block> blockChain = new ArrayList<>();
    private final static int difficulty = 5;

    public static void main(String[] args) {
        Miner miner = new Miner(difficulty);

        // Create transaction
        String firstTransaction = "Thomas pays Lucy 5 CC";
        // Miner listens to this transaction and mines block
        Block firstBlock = miner.mineBlock(firstTransaction, "0");
        // Block is added to the blockchain
        blockChain.add(firstBlock);

        // Same for the second and third time
        String secondTransaction = "John pays Paul 2 CC";
        Block secondBlock = miner.mineBlock(secondTransaction, firstBlock.getHash());
        blockChain.add(secondBlock);
        String thirdTransaction = "Paul pays Thomas 4 CC";
        Block thirdBLock = miner.mineBlock(thirdTransaction, secondBlock.getHash());
        blockChain.add(thirdBLock);

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockChain);
        System.out.println("Blockchain:");
        System.out.println(blockchainJson);
        System.out.println();
        System.out.println("Is blockchain valid?: " + isBlockchainValid());
    }

    private static Boolean isBlockchainValid(){
        if (blockChain.size() > 0){
            for (int i = 0; i < blockChain.size(); i++){
                Block block = blockChain.get(i);

                // has valid hash
                String expectedHash = Hasher.calculateHash(block.getPreviousHash(), block.getTransaction(), block.getNonce());
                if (!expectedHash.equals(block.getHash())){
                    System.out.println("Block has invalid hash.");
                    return false;
                }

                // block was mined
                String hashTarget = new String(new char[difficulty]).replace('\0', '0');
                if (!block.getHash().substring(0, difficulty).equals(hashTarget)){
                    System.out.println("Block wasn't mined.");
                    return false;
                }

                // for every block except first compare previousHash
                if (i > 0){
                    Block previousBlock = blockChain.get(i - 1);
                    // is previous hash legit?
                    if (!block.getPreviousHash().equals(previousBlock.getHash())){
                        System.out.println("Block has invalid previous hash.");
                        return false;
                    }
                }
            }
        }else {
            System.out.println("Empty Blockchain.");
            return true;
        }
        return true;
    }
}