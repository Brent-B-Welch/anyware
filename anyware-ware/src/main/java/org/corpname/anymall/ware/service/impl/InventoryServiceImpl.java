package org.corpname.anymall.ware.service.impl;

import org.corpname.anymall.ware.model.InventoryItem;
import org.corpname.anymall.ware.repository.InventoryRepository;
import org.corpname.anymall.ware.service.InventoryService;
import org.corpname.anymall.ware.vo.InventoryItemView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("inventoryService")
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public List<InventoryItemView> getAll() {
        List<InventoryItem> inventoryItemList = inventoryRepository.findAll();
        return inventoryItemList.stream().map(i -> InventoryItemView.builder()
                .artId(i.getArticleId())
                .name(i.getName())
                .stock(i.getStock())
                .build()
        ).collect(Collectors.toList());
    }

    @Override
    public InventoryItemView findByArtId(Long id) {
        InventoryItem inventoryItem = inventoryRepository.getOne(id);
        return Optional.ofNullable(inventoryItem)
                .map(i -> InventoryItemView.builder()
                        .artId(i.getArticleId())
                        .name(i.getName())
                        .stock(i.getStock())
                        .build()
                ).get();
    }

    @Override
    public InventoryItemView createInventoryItem(InventoryItem inventoryItem) {
        InventoryItem it = inventoryRepository.insert(inventoryItem);

        return Optional.ofNullable(it)
                .map(item -> InventoryItemView.builder()
                        .artId(item.getArticleId())
                        .name(item.getName())
                        .stock(item.getStock())
                        .build()
                ).get();
    }

    @Override
    public InventoryItemView updateInventoryItem(Long id, Integer stock) {
        return inventoryRepository.update(id, stock);
    }

    @Override
    public InventoryItemView deleteByArtId(Long id) {
        return inventoryRepository.delete(id);
    }


}
