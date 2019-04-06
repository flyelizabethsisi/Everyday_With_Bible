package com.example.everydaywithbible.model;

import java.util.ArrayList;
import java.util.List;

public class StoryData {

    private StoryKey the_creation, adam_and_eve, cain_and_abel, the_great_flood, the_tower_of_babel, god_calls_abraham, sodom_and_gomorrah,
            abrahams_obedience, isaac_marries_rebekah, esaus_birthright, isaac_blesses_jacob, jacob_and_laban, jacob_wrestles,
            revenge_against_schechem, joseph_in_prison, joseph_as_a_ruler, family_reunion, moses_birth, the_burning_bush, the_ten_plagues,
            the_exodus, the_red_sea, the_gold_calf, exploring_the_land, rebellion_in_the_ranks, balak_and_balaam, rahab_and_the_spies,
            jericho_falls, gibeons_con_artists, deborah_and_barak, gideon_as_judge, abimelechs_ambition, samson_as_judge,
            ruth_naomi_and_boaz, samuel_is_born, samuel_the_prophet, saul_becomes_king, jonathans_bravery, sauls_disobedience,
            david_kills_goliath, david_and_jonathan, nabal_and_abigail, sauls_death, davids_success, david_and_bathsheba,
            amnon_and_tamar, absalom, solomons_wisdom, jeroboam_and_rehoboam, elijahs_challenge, god_speaks_to_elijah, micaiah_the_prophet,
            chariot_of_fire, elisha_heals_naaman, famine_and_unbelief, joash_and_jehoiada, hezekiah_trusts_god, josiahs_reign,
            fall_of_jerusalem, davids_power, davids_census, jehoshaphat_and_ahab, ezra_rebuilds_the_altar, nehemiah_builds_the_wall,
            enemy_opposition, nehemiahs_justice, esther_saves_the_jews, job_is_tested, ezekiels_vision, the_fiery_furnace,
            the_lions_den, jonah, jesus_is_born, wise_men_and_king_herod, jesus_is_tempted, jesus_feeds_5000, the_bread_of_life,
            jesus_walks_on_water, the_good_samaritan, the_lost_son, jesus_raises_lazarus, jesus_and_zacchaeus, the_triumphal_entry,
            the_last_supper, jesus_trial, jesus_crucifixion, jesus_resurrection, jesus_ascension, the_holy_spirit_comes,
            the_apostles_courage, ananias_and_sapphira, philip_and_the_eunuch, saul_encounters_jesus, peter_and_cornelius,
            paul_in_corinth, paul_in_ephesus, paul_goes_to_rome;


    public StoryData(StoryKey the_creation, StoryKey adam_and_eve, StoryKey cain_and_abel, StoryKey the_great_flood, StoryKey the_tower_of_babel, StoryKey god_calls_abraham, StoryKey sodom_and_gomorrah, StoryKey abrahams_obedience, StoryKey isaac_marries_rebekah, StoryKey esaus_birthright, StoryKey isaac_blesses_jacob, StoryKey jacob_and_laban, StoryKey jacob_wrestles, StoryKey revenge_against_schechem, StoryKey joseph_in_prison, StoryKey joseph_as_a_ruler, StoryKey family_reunion, StoryKey moses_birth, StoryKey the_burning_bush, StoryKey the_ten_plagues, StoryKey the_exodus, StoryKey the_red_sea, StoryKey the_gold_calf, StoryKey exploring_the_land, StoryKey rebellion_in_the_ranks, StoryKey balak_and_balaam, StoryKey rahab_and_the_spies, StoryKey jericho_falls, StoryKey gibeons_con_artists, StoryKey deborah_and_barak, StoryKey gideon_as_judge, StoryKey abimelechs_ambition, StoryKey samson_as_judge, StoryKey ruth_naomi_and_boaz, StoryKey samuel_is_born, StoryKey samuel_the_prophet, StoryKey saul_becomes_king, StoryKey jonathans_bravery, StoryKey sauls_disobedience, StoryKey david_kills_goliath, StoryKey david_and_jonathan, StoryKey nabal_and_abigail, StoryKey sauls_death, StoryKey davids_success, StoryKey david_and_bathsheba, StoryKey amnon_and_tamar, StoryKey absalom, StoryKey solomons_wisdom, StoryKey jeroboam_and_rehoboam, StoryKey elijahs_challenge, StoryKey god_speaks_to_elijah, StoryKey micaiah_the_prophet, StoryKey chariot_of_fire, StoryKey elisha_heals_naaman, StoryKey famine_and_unbelief, StoryKey joash_and_jehoiada, StoryKey hezekiah_trusts_god, StoryKey josiahs_reign, StoryKey fall_of_jerusalem, StoryKey davids_power, StoryKey davids_census, StoryKey jehoshaphat_and_ahab, StoryKey ezra_rebuilds_the_altar, StoryKey nehemiah_builds_the_wall, StoryKey enemy_opposition, StoryKey nehemiahs_justice, StoryKey esther_saves_the_jews, StoryKey job_is_tested, StoryKey ezekiels_vision, StoryKey the_fiery_furnace, StoryKey the_lions_den, StoryKey jonah, StoryKey jesus_is_born, StoryKey wise_men_and_king_herod, StoryKey jesus_is_tempted, StoryKey jesus_feeds_5000, StoryKey the_bread_of_life, StoryKey jesus_walks_on_water, StoryKey the_good_samaritan, StoryKey the_lost_son, StoryKey jesus_raises_lazarus, StoryKey jesus_and_zacchaeus, StoryKey the_triumphal_entry, StoryKey the_last_supper, StoryKey jesus_trial, StoryKey jesus_crucifixion, StoryKey jesus_resurrection, StoryKey jesus_ascension, StoryKey the_holy_spirit_comes, StoryKey the_apostles_courage, StoryKey ananias_and_sapphira, StoryKey philip_and_the_eunuch, StoryKey saul_encounters_jesus, StoryKey peter_and_cornelius, StoryKey paul_in_corinth, StoryKey paul_in_ephesus, StoryKey paul_goes_to_rome) {
        this.the_creation = the_creation;
        this.adam_and_eve = adam_and_eve;
        this.cain_and_abel = cain_and_abel;
        this.the_great_flood = the_great_flood;
        this.the_tower_of_babel = the_tower_of_babel;
        this.god_calls_abraham = god_calls_abraham;
        this.sodom_and_gomorrah = sodom_and_gomorrah;
        this.abrahams_obedience = abrahams_obedience;
        this.isaac_marries_rebekah = isaac_marries_rebekah;
        this.esaus_birthright = esaus_birthright;
        this.isaac_blesses_jacob = isaac_blesses_jacob;
        this.jacob_and_laban = jacob_and_laban;
        this.jacob_wrestles = jacob_wrestles;
        this.revenge_against_schechem = revenge_against_schechem;
        this.joseph_in_prison = joseph_in_prison;
        this.joseph_as_a_ruler = joseph_as_a_ruler;
        this.family_reunion = family_reunion;
        this.moses_birth = moses_birth;
        this.the_burning_bush = the_burning_bush;
        this.the_ten_plagues = the_ten_plagues;
        this.the_exodus = the_exodus;
        this.the_red_sea = the_red_sea;
        this.the_gold_calf = the_gold_calf;
        this.exploring_the_land = exploring_the_land;
        this.rebellion_in_the_ranks = rebellion_in_the_ranks;
        this.balak_and_balaam = balak_and_balaam;
        this.rahab_and_the_spies = rahab_and_the_spies;
        this.jericho_falls = jericho_falls;
        this.gibeons_con_artists = gibeons_con_artists;
        this.deborah_and_barak = deborah_and_barak;
        this.gideon_as_judge = gideon_as_judge;
        this.abimelechs_ambition = abimelechs_ambition;
        this.samson_as_judge = samson_as_judge;
        this.ruth_naomi_and_boaz = ruth_naomi_and_boaz;
        this.samuel_is_born = samuel_is_born;
        this.samuel_the_prophet = samuel_the_prophet;
        this.saul_becomes_king = saul_becomes_king;
        this.jonathans_bravery = jonathans_bravery;
        this.sauls_disobedience = sauls_disobedience;
        this.david_kills_goliath = david_kills_goliath;
        this.david_and_jonathan = david_and_jonathan;
        this.nabal_and_abigail = nabal_and_abigail;
        this.sauls_death = sauls_death;
        this.davids_success = davids_success;
        this.david_and_bathsheba = david_and_bathsheba;
        this.amnon_and_tamar = amnon_and_tamar;
        this.absalom = absalom;
        this.solomons_wisdom = solomons_wisdom;
        this.jeroboam_and_rehoboam = jeroboam_and_rehoboam;
        this.elijahs_challenge = elijahs_challenge;
        this.god_speaks_to_elijah = god_speaks_to_elijah;
        this.micaiah_the_prophet = micaiah_the_prophet;
        this.chariot_of_fire = chariot_of_fire;
        this.elisha_heals_naaman = elisha_heals_naaman;
        this.famine_and_unbelief = famine_and_unbelief;
        this.joash_and_jehoiada = joash_and_jehoiada;
        this.hezekiah_trusts_god = hezekiah_trusts_god;
        this.josiahs_reign = josiahs_reign;
        this.fall_of_jerusalem = fall_of_jerusalem;
        this.davids_power = davids_power;
        this.davids_census = davids_census;
        this.jehoshaphat_and_ahab = jehoshaphat_and_ahab;
        this.ezra_rebuilds_the_altar = ezra_rebuilds_the_altar;
        this.nehemiah_builds_the_wall = nehemiah_builds_the_wall;
        this.enemy_opposition = enemy_opposition;
        this.nehemiahs_justice = nehemiahs_justice;
        this.esther_saves_the_jews = esther_saves_the_jews;
        this.job_is_tested = job_is_tested;
        this.ezekiels_vision = ezekiels_vision;
        this.the_fiery_furnace = the_fiery_furnace;
        this.the_lions_den = the_lions_den;
        this.jonah = jonah;
        this.jesus_is_born = jesus_is_born;
        this.wise_men_and_king_herod = wise_men_and_king_herod;
        this.jesus_is_tempted = jesus_is_tempted;
        this.jesus_feeds_5000 = jesus_feeds_5000;
        this.the_bread_of_life = the_bread_of_life;
        this.jesus_walks_on_water = jesus_walks_on_water;
        this.the_good_samaritan = the_good_samaritan;
        this.the_lost_son = the_lost_son;
        this.jesus_raises_lazarus = jesus_raises_lazarus;
        this.jesus_and_zacchaeus = jesus_and_zacchaeus;
        this.the_triumphal_entry = the_triumphal_entry;
        this.the_last_supper = the_last_supper;
        this.jesus_trial = jesus_trial;
        this.jesus_crucifixion = jesus_crucifixion;
        this.jesus_resurrection = jesus_resurrection;
        this.jesus_ascension = jesus_ascension;
        this.the_holy_spirit_comes = the_holy_spirit_comes;
        this.the_apostles_courage = the_apostles_courage;
        this.ananias_and_sapphira = ananias_and_sapphira;
        this.philip_and_the_eunuch = philip_and_the_eunuch;
        this.saul_encounters_jesus = saul_encounters_jesus;
        this.peter_and_cornelius = peter_and_cornelius;
        this.paul_in_corinth = paul_in_corinth;
        this.paul_in_ephesus = paul_in_ephesus;
        this.paul_goes_to_rome = paul_goes_to_rome;
    }



    public List<StoryKey> getStoryTitleList() {
        List<StoryKey> storyTitleList = new ArrayList<>();
        storyTitleList.add(the_creation); //list 4
        storyTitleList.add(adam_and_eve); //list 4
        storyTitleList.add(cain_and_abel); //list 4
        storyTitleList.add(the_great_flood);
        storyTitleList.add(the_tower_of_babel);
        storyTitleList.add(god_calls_abraham);
        storyTitleList.add(sodom_and_gomorrah);
        storyTitleList.add(abrahams_obedience);
        storyTitleList.add(isaac_marries_rebekah);
        storyTitleList.add(esaus_birthright);
        storyTitleList.add(isaac_blesses_jacob);
        storyTitleList.add(jacob_and_laban);
        storyTitleList.add(jacob_wrestles);
        storyTitleList.add(revenge_against_schechem);
        storyTitleList.add(joseph_in_prison);
        storyTitleList.add(joseph_as_a_ruler);
        storyTitleList.add(family_reunion);
        storyTitleList.add(moses_birth);
        storyTitleList.add(the_burning_bush);
        storyTitleList.add(the_ten_plagues);
        storyTitleList.add(the_exodus);
        storyTitleList.add(the_red_sea);
        storyTitleList.add(the_gold_calf);
        storyTitleList.add(exploring_the_land);
        storyTitleList.add(rebellion_in_the_ranks);
        storyTitleList.add(balak_and_balaam);
        storyTitleList.add(rahab_and_the_spies);
        storyTitleList.add(jericho_falls);
        storyTitleList.add(gibeons_con_artists);
        storyTitleList.add(deborah_and_barak);
        storyTitleList.add(gideon_as_judge);
        storyTitleList.add(abimelechs_ambition);
        storyTitleList.add(samson_as_judge);
        storyTitleList.add(ruth_naomi_and_boaz);
        storyTitleList.add(samuel_is_born);
        storyTitleList.add(samuel_the_prophet);
        storyTitleList.add(saul_becomes_king);
        storyTitleList.add(jonathans_bravery);
        storyTitleList.add(sauls_disobedience);
        storyTitleList.add(david_kills_goliath);
        storyTitleList.add(david_and_jonathan);
        storyTitleList.add(nabal_and_abigail);
        storyTitleList.add(sauls_death);
        storyTitleList.add(davids_success);
        storyTitleList.add(david_and_bathsheba);
        storyTitleList.add(amnon_and_tamar);
        storyTitleList.add(absalom);
        storyTitleList.add(solomons_wisdom);
        storyTitleList.add(jeroboam_and_rehoboam);
        storyTitleList.add(elijahs_challenge);
        storyTitleList.add(god_speaks_to_elijah);
        storyTitleList.add(micaiah_the_prophet);
        storyTitleList.add(chariot_of_fire);
        storyTitleList.add(elisha_heals_naaman);
        storyTitleList.add(famine_and_unbelief);
        storyTitleList.add(joash_and_jehoiada);
        storyTitleList.add(hezekiah_trusts_god);
        storyTitleList.add(josiahs_reign);
        storyTitleList.add(fall_of_jerusalem);
        storyTitleList.add(davids_power);
        storyTitleList.add(davids_census);
        storyTitleList.add(jehoshaphat_and_ahab);
        storyTitleList.add(ezra_rebuilds_the_altar);
        storyTitleList.add(nehemiah_builds_the_wall);
        storyTitleList.add(enemy_opposition);
        storyTitleList.add(nehemiahs_justice);
        storyTitleList.add(esther_saves_the_jews);
        storyTitleList.add(job_is_tested);
        storyTitleList.add(ezekiels_vision);
        storyTitleList.add(the_fiery_furnace);
        storyTitleList.add(the_lions_den);
        storyTitleList.add(jonah);
        storyTitleList.add(jesus_is_born);
        storyTitleList.add(wise_men_and_king_herod);
        storyTitleList.add(jesus_is_tempted);
        storyTitleList.add(jesus_feeds_5000);
        storyTitleList.add(the_bread_of_life);
        storyTitleList.add(jesus_walks_on_water);
        storyTitleList.add(the_good_samaritan);
        storyTitleList.add(the_lost_son);
        storyTitleList.add(jesus_raises_lazarus);
        storyTitleList.add(jesus_and_zacchaeus);
        storyTitleList.add(the_triumphal_entry);
        storyTitleList.add(the_last_supper);
        storyTitleList.add(jesus_trial);
        storyTitleList.add(jesus_crucifixion);
        storyTitleList.add(jesus_resurrection);
        storyTitleList.add(jesus_ascension);
        storyTitleList.add(the_holy_spirit_comes);
        storyTitleList.add(the_apostles_courage);
        storyTitleList.add(ananias_and_sapphira);
        storyTitleList.add(philip_and_the_eunuch);
        storyTitleList.add(saul_encounters_jesus);
        storyTitleList.add(peter_and_cornelius);
        storyTitleList.add(paul_in_corinth);
        storyTitleList.add(paul_in_ephesus);
        storyTitleList.add(paul_goes_to_rome);

        return storyTitleList;
    }
}
