import java.util.List;
import java.util.ArrayList;

public class MemoryAllocator implements IMemoryAllocator {
    private int totalSize;
    private IAllocationAlgorithm algorithm;

    private List<MemoryBlock> blocks;

    public MemoryAllocator(int totalSize, IAllocationAlgorithm algorithm) {
        this.totalSize = totalSize;
        this.algorithm = algorithm;
        blocks = new ArrayList<MemoryBlock>();

        MemoryBlock block = new MemoryBlock();
        block.setSize(totalSize);
        blocks.add(block);
    }

    @Override
    public boolean Allocate(String objectName, int size) {
        MemoryBlock block = algorithm.GetMemoryBlock(blocks, size);

        if (block == null) {
            return false;
        }

        MemoryBlock newBlock = createMemoryBlock(objectName, size);
        insertMemoryBlock(blocks, block, newBlock);
        updateBlockSize(block, size);

        return true;
    }

    private MemoryBlock createMemoryBlock(String objectName, int size) {
        MemoryBlock newBlock = new MemoryBlock();
        newBlock.setSize(size);
        newBlock.setObject(objectName);
        return newBlock;
    }

    private void insertMemoryBlock(List<MemoryBlock> blocks, MemoryBlock block, MemoryBlock newBlock) {
        int idxBlock = blocks.indexOf(block);
        blocks.add(idxBlock, newBlock);
    }

    private void updateBlockSize(MemoryBlock block, int size) {
        block.setSize(block.getSize() - size);
        if (block.getSize() == 0) {
            blocks.remove(block);
        }
    }

    @Override
    public boolean DeAllocate(String objectName) {
        MemoryBlock block = SearchByName(objectName);

        if (block == null) {
            return false;
        }

        block.setObject(null);

        int blockIndex = blocks.indexOf(block);
        mergeConsecutiveFreeBlocks(blockIndex);

        return true;
    }

    private void mergeConsecutiveFreeBlocks(int startIndex) {
        int leftIndex = startIndex;
        while (leftIndex > 0 && blocks.get(leftIndex - 1).IsFree()) {
            leftIndex--;
        }

        int rightIndex = startIndex;
        while (rightIndex < blocks.size() - 1 && blocks.get(rightIndex + 1).IsFree()) {
            rightIndex++;
        }

        if (leftIndex < rightIndex) {
            int mergedSize = 0;

            for (int i = leftIndex; i <= rightIndex; i++) {
                mergedSize += blocks.get(i).getSize();
            }

            blocks.get(leftIndex).setSize(mergedSize);

            for (int i = rightIndex; i > leftIndex; i--) {
                blocks.remove(i);
            }
        }
    }

    private MemoryBlock SearchByName(String objectName) {
        for (MemoryBlock b : blocks) {
            if (objectName.equals(b.getObject())) {
                return b;
            }
        }

        return null;
    }

    @Override
    public boolean IsEmpty() {
        for (MemoryBlock block : blocks) {
            if (!block.IsFree()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean IsFull() {
        int freeSpace = 0;
        for (MemoryBlock block : blocks) {
            if (block.IsFree()) {
                freeSpace += block.getSize();
            }
        }
        return freeSpace == totalSize;
    }

    @Override
    public void ShowMemory() {
        System.out.println("-----------------------");

        for (MemoryBlock m : blocks) {
            System.out.println(m.getObject() + " " + m.getSize());
        }

        System.out.println("-----------------------");
    }
}
