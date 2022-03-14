package com.model;

public enum BookSubject {
    ArtsAndPhotography(1),
    BiographiesAndMemoirs(2),
    BusinessAndMoney(3),
    Calendars(4),
    ChildrenBooks(5),
    ChristianBooksAndBibles(6),
    ComicsAndGraphicNovels(7),
    ComputersAndTechnology(8),
    CookbooksAndFoodAndWine(9),
    CraftsHobbiesHome(10),
    EducationTeaching(11),
    EngineeringTransportation(12),
    HealthFitnessDieting(13),
    History(14),
    HumorEntertainment(15),
    Law(16),
    LGBTQBooks(17),
    LiteratureFiction(18),
    MedicalBooks(19),
    MysteryThrillerSuspense(20),
    ParentingRelationships(21),
    PoliticsSocialSciences(22),
    Reference(23),
    ReligionSpirituality(24),
    Romance(25),
    ScienceMath(26),
    ScienceFictionFantasy(27),
    SelfHelp(28),
    SportsOutdoors(29),
    TeenYoungAdult(30),
    TestPreparation(31),
    Travel(32);

    private int numValue;

    BookSubject(int numValue) {
        this.numValue = numValue;
    }

    public int getNumValue() {
        return numValue;
    }
}
