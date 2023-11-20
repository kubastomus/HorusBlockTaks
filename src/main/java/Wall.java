import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Wall implements Structure {

    private List<Block> blocks;

    public Wall() {
        this.blocks = new ArrayList<>();
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return blocks.stream()
                .filter(block -> block.getColor().equals(color))
                .findFirst();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return blocks.stream()
                .filter(block -> block.getMaterial().equals(material))
                .collect(Collectors.toList());
    }

    @Override
    public int count() {
        return blocks.size();
    }

    // Metody sprawdzające obiekty implementujące CompositeBlock

    // Sprawdza, czy dany blok jest instancją CompositeBlock
    public boolean isCompositeBlock(Block block) {
        return block instanceof CompositeBlock;
    }

    // Sprawdza czy w liście znajdują się elementy implementujące CompositeBlock
    public boolean containsCompositeBlocks() {
        return blocks.stream().anyMatch(this::isCompositeBlock);
    }

    // Zwraca listę bloków dla danego CompositeBlock
    public List<Block> getBlocksForCompositeBlock(CompositeBlock compositeBlock) {
        return compositeBlock.getBlocks();
    }

    // Dodawanie bloku do listy
    public void addBlock(Block block) {
        blocks.add(block);
    }

}