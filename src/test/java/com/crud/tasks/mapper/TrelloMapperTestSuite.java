package com.crud.tasks.mapper;


import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TrelloMapperTestSuite {

    @Autowired
    private TrelloMapper trelloMapper;


    @Test
    void testMapToBoard() {
        //Given
        List<TrelloListDto> trelloBoardDtoList = new ArrayList<>();
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("Adam", "35", trelloBoardDtoList);

        //When
        TrelloBoard trelloBoard = trelloMapper.mapToBoard(trelloBoardDto);

        //Then
        assertEquals("Adam", trelloBoard.getName());
        assertEquals("35", trelloBoard.getId());
        assertEquals(0, trelloBoard.getLists().size());

    }

    @Test
    void testMapToBoards() {
        //Given
        List<TrelloListDto> trelloListDtoList = new ArrayList<>();
        List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("to do list", "4", trelloListDtoList);
        trelloBoardDtoList.add(trelloBoardDto);

        //When
        List<TrelloBoard> trelloBoardList = trelloMapper.mapToBoards(trelloBoardDtoList);

        //Then
        assertEquals(1, trelloBoardList.size());
        assertEquals("to do list", trelloBoardList.get(0).getName());

    }

    @Test
    void testMapToBoardsDto() {
        //Given
        List<TrelloList> trelloListList = new ArrayList<>();
        List<TrelloBoard> trelloBoardList = new ArrayList<>();
        TrelloBoard trelloBoard = new TrelloBoard("to do list", "4", trelloListList);
        trelloBoardList.add(trelloBoard);

        //When
        List<TrelloBoardDto> trelloBoardDtoList = trelloMapper.mapToBoardsDto(trelloBoardList);

        //Then
        assertEquals(1, trelloBoardDtoList.size());
        assertEquals("to do list", trelloBoardDtoList.get(0).getName());

    }

    @Test
    void testMapToList() {
        //Given
        List<TrelloListDto> trelloListDtoList = new ArrayList<>();
        TrelloListDto trelloListDto = new TrelloListDto("1", "to do list", false);
        trelloListDtoList.add(trelloListDto);

        //When
        List<TrelloList> trelloLists = trelloMapper.mapToList(trelloListDtoList);

        //Then
        assertEquals(1, trelloLists.size());
        assertEquals("to do list", trelloLists.get(0).getName());

    }

    @Test
    void testMapToListDto() {
        //Given
        List<TrelloList> trelloLists = new ArrayList<>();
        TrelloList trelloList = new TrelloList("1", "to do list", false);
        trelloLists.add(trelloList);

        //When
        List<TrelloListDto> trelloListDtoList = trelloMapper.mapToListDto(trelloLists);

        //Then
        assertEquals(1, trelloListDtoList.size());
        assertEquals("to do list", trelloListDtoList.get(0).getName());

    }

    @Test
    void testMapToCard() {
        //Given
        TrelloCard trelloCard = new TrelloCard("bike repair", "test description", "3", "2");

        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        //Then
        assertEquals("bike repair", trelloCardDto.getName());
        assertEquals("test description", trelloCardDto.getDescription());
        assertEquals("3", trelloCardDto.getPos());
        assertEquals("2", trelloCardDto.getListId());

    }

    @Test
    void testMapToCardDto() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("bike repair", "test description", "3", "2");

        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        //Then
        assertEquals("bike repair", trelloCard.getName());
        assertEquals("test description", trelloCard.getDescription());
        assertEquals("3", trelloCard.getPos());
        assertEquals("2", trelloCard.getListId());

    }
}
