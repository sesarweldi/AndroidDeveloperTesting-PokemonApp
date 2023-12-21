package com.well.testpokemonapp.data.response

import com.google.gson.annotations.SerializedName

data class PokemonDetailResponseModel(
    @SerializedName("abilities") var abilities: ArrayList<Abilities> = arrayListOf(),
    @SerializedName("base_experience") var baseExperience: Int? = null,
    @SerializedName("forms") var forms: ArrayList<Forms> = arrayListOf(),
    @SerializedName("game_indices") var gameIndices: ArrayList<GameIndices> = arrayListOf(),
    @SerializedName("height") var height: Int? = null,
    @SerializedName("id") var id: Int? = null,
    @SerializedName("is_default") var isDefault: Boolean? = null,
    @SerializedName("location_area_encounters") var locationAreaEncounters: String? = null,
    @SerializedName("moves") var moves: ArrayList<Moves> = arrayListOf(),
    @SerializedName("name") var name: String? = null,
    @SerializedName("order") var order: Int? = null,
    @SerializedName("past_abilities") var pastAbilities: ArrayList<String> = arrayListOf(),
    @SerializedName("past_types") var pastTypes: ArrayList<String> = arrayListOf(),
    @SerializedName("species") var species: Species? = Species(),
    @SerializedName("sprites") var sprites: Sprites? = Sprites(),
    @SerializedName("stats") var stats: ArrayList<Stats> = arrayListOf(),
    @SerializedName("types") var types: ArrayList<Types> = arrayListOf(),
    @SerializedName("weight") var weight: Int? = null
) {
    data class Abilities(
        @SerializedName("ability") var ability: Ability? = Ability(),
        @SerializedName("is_hidden") var isHidden: Boolean? = null,
        @SerializedName("slot") var slot: Int? = null
    )

    data class Ability(

        @SerializedName("name") var name: String? = null,
        @SerializedName("url") var url: String? = null

    )

    data class Forms(
        @SerializedName("name") var name: String? = null,
        @SerializedName("url") var url: String? = null
    )

    data class GameIndices(
        @SerializedName("game_index") var gameIndex: Int? = null,
        @SerializedName("version") var version: Version? = Version()
    )

    data class Home(
        @SerializedName("front_default") var frontDefault: String? = null,
        @SerializedName("front_female") var frontFemale: String? = null,
        @SerializedName("front_shiny") var frontShiny: String? = null,
        @SerializedName("front_shiny_female") var frontShinyFemale: String? = null
    )

    data class MoveLearnMethod(

        @SerializedName("name") var name: String? = null,
        @SerializedName("url") var url: String? = null

    )

    data class Moves(
        @SerializedName("move") var move: Move? = Move(),
        @SerializedName("version_group_details") var versionGroupDetails: ArrayList<VersionGroupDetails> = arrayListOf()
    )

    data class Move(

        @SerializedName("name") var name: String? = null,
        @SerializedName("url") var url: String? = null

    )

    data class DreamWorld(
        @SerializedName("front_default") var frontDefault: String? = null,
        @SerializedName("front_female") var frontFemale: String? = null
    )

    data class Species(
        @SerializedName("name") var name: String? = null,
        @SerializedName("url") var url: String? = null
    )

    data class Sprites(
        @SerializedName("back_default") var backDefault: String? = null,
        @SerializedName("back_female") var backFemale: String? = null,
        @SerializedName("back_shiny") var backShiny: String? = null,
        @SerializedName("back_shiny_female") var backShinyFemale: String? = null,
        @SerializedName("front_default") var frontDefault: String? = null,
        @SerializedName("front_female") var frontFemale: String? = null,
        @SerializedName("front_shiny") var frontShiny: String? = null,
        @SerializedName("front_shiny_female") var frontShinyFemale: String? = null,
        @SerializedName("other") var other: Other? = Other(),
        @SerializedName("versions") var versions: Versions? = Versions()

    )

    data class Stat(
        @SerializedName("name") var name: String? = null,
        @SerializedName("url") var url: String? = null

    )

    data class Stats(
        @SerializedName("base_stat") var baseStat: Int? = null,
        @SerializedName("effort") var effort: Int? = null,
        @SerializedName("stat") var stat: Stat? = Stat()
    )

    data class Type(
        @SerializedName("name") var name: String? = null,
        @SerializedName("url") var url: String? = null
    )

    data class Types(
        @SerializedName("slot") var slot: Int? = null,
        @SerializedName("type") var type: Type? = Type()
    )

    data class Version(
        @SerializedName("name") var name: String? = null,
        @SerializedName("url") var url: String? = null
    )

    data class VersionGroup(
        @SerializedName("name") var name: String? = null,
        @SerializedName("url") var url: String? = null
    )

    data class VersionGroupDetails(
        @SerializedName("level_learned_at") var levelLearnedAt: Int? = null,
        @SerializedName("move_learn_method") var moveLearnMethod: MoveLearnMethod? = MoveLearnMethod(),
        @SerializedName("version_group") var versionGroup: VersionGroup? = VersionGroup()

    )

    data class Yellow(

        @SerializedName("back_default") var backDefault: String? = null,
        @SerializedName("back_gray") var backGray: String? = null,
        @SerializedName("back_transparent") var backTransparent: String? = null,
        @SerializedName("front_default") var frontDefault: String? = null,
        @SerializedName("front_gray") var frontGray: String? = null,
        @SerializedName("front_transparent") var frontTransparent: String? = null

    )

    data class Xy(
        @SerializedName("front_default")
        var frontDefault: String? = null,
        @SerializedName("front_female")
        var frontFemale: String? = null,
        @SerializedName("front_shiny")
        var frontShiny: String? = null,
        @SerializedName("front_shiny_female")
        var frontShinyFemale: String? = null
    )

    data class Versions(
        @SerializedName("generation-i") var generationi: Generationi? = Generationi(),
        @SerializedName("generation-ii")
        var generationii: Generationii? = Generationii(),
        @SerializedName("generation-iii")
        var generationiii: Generationiii? = Generationiii(),
        @SerializedName("generation-iv")
        var generationiv: Generationiv? = Generationiv(),
        @SerializedName("generation-v")
        var generationv: Generationv? = Generationv(),
        @SerializedName("generation-vi")
        var generationvi: Generationvi? = Generationvi(),
        @SerializedName("generation-vii")
        var generationvii: Generationvii? = Generationvii(),
        @SerializedName("generation-viii")
        var generationviii: Generationviii? = Generationviii()
    )

    data class Ultrasunultramoon(

        @SerializedName("front_default")
        var frontDefault: String? = null,

        @SerializedName("front_female")
        var frontFemale: String? = null,

        @SerializedName("front_shiny")
        var frontShiny: String? = null,

        @SerializedName("front_shiny_female")
        var frontShinyFemale: String? = null

    )

    data class Silver(
        @SerializedName("back_default") var backDefault: String? = null,
        @SerializedName("back_shiny") var backShiny: String? = null,
        @SerializedName("front_default") var frontDefault: String? = null,
        @SerializedName("front_shiny") var frontShiny: String? = null,
        @SerializedName("front_transparent") var frontTransparent: String? = null
    )

    data class RubySapphire(
        @SerializedName("back_default")
        var backDefault: String? = null,
        @SerializedName("back_shiny")
        var backShiny: String? = null,
        @SerializedName("front_default")
        var frontDefault: String? = null,
        @SerializedName("front_shiny")
        var frontShiny: String? = null
    )

    data class RedBlue(
        @SerializedName("back_default")
        var backDefault: String? = null,
        @SerializedName("back_gray")
        var backGray: String? = null,
        @SerializedName("back_transparent")
        var backTransparent: String? = null,
        @SerializedName("front_default")
        var frontDefault: String? = null,
        @SerializedName("front_gray")
        var frontGray: String? = null,
        @SerializedName("front_transparent")
        var frontTransparent: String? = null

    )

    data class Platinum(
        @SerializedName("back_default") var backDefault: String? = null,
        @SerializedName("back_female") var backFemale: String? = null,
        @SerializedName("back_shiny") var backShiny: String? = null,
        @SerializedName("back_shiny_female") var backShinyFemale: String? = null,
        @SerializedName("front_default") var frontDefault: String? = null,
        @SerializedName("front_female") var frontFemale: String? = null,
        @SerializedName("front_shiny") var frontShiny: String? = null,
        @SerializedName("front_shiny_female") var frontShinyFemale: String? = null
    )

    data class Other(
        @SerializedName("dream_world") var dreamWorld: DreamWorld? = DreamWorld(),
        @SerializedName("home") var home: Home? = Home(),
        @SerializedName("official-artwork") var officialArtwork: OfficialArtwork? = OfficialArtwork()
    )

    data class OmegarubyAlphasapphire(
        @SerializedName("front_default")
        var frontDefault: String? = null,
        @SerializedName("front_female")
        var frontFemale: String? = null,
        @SerializedName("front_shiny")
        var frontShiny: String? = null,
        @SerializedName("front_shiny_female")
        var frontShinyFemale: String? = null

    )

    data class OfficialArtwork(
        @SerializedName("front_default")
        var frontDefault: String? = null,
        @SerializedName("front_shiny")
        var frontShiny: String? = null

    )

    data class Icons(
        @SerializedName("front_default") var frontDefault: String? = null,
        @SerializedName("front_female") var frontFemale: String? = null
    )


    data class HeartgoldSoulsilver(
        @SerializedName("back_default")
        var backDefault: String? = null,
        @SerializedName("back_female")
        var backFemale: String? = null,
        @SerializedName("back_shiny")
        var backShiny: String? = null,
        @SerializedName("back_shiny_female")
        var backShinyFemale: String? = null,
        @SerializedName("front_default")
        var frontDefault: String? = null,
        @SerializedName("front_female")
        var frontFemale: String? = null,
        @SerializedName("front_shiny")
        var frontShiny: String? = null,
        @SerializedName("front_shiny_female")
        var frontShinyFemale: String? = null
    )

    data class Gold(
        @SerializedName("back_default") var backDefault: String? = null,
        @SerializedName("back_shiny") var backShiny: String? = null,
        @SerializedName("front_default") var frontDefault: String? = null,
        @SerializedName("front_shiny") var frontShiny: String? = null,
        @SerializedName("front_transparent") var frontTransparent: String? = null

    )

    data class Generationviii(
        @SerializedName("icons")
        var icons: Icons? = Icons()
    )

    data class Generationvii(
        @SerializedName("icons")
        var icons: Icons? = Icons(),
        @SerializedName("ultra-sun-ultra-moon")
        var ultrasunultramoon: Ultrasunultramoon = Ultrasunultramoon()
    )


    data class Generationvi(
        @SerializedName("omegaruby-alphasapphire")
        var omegarubyAlphasapphire: OmegarubyAlphasapphire = OmegarubyAlphasapphire(),
        var xy: Xy? = Xy()
    )

    data class Generationv(
        @SerializedName("black-white")
        var blackWhite: BlackWhite? = BlackWhite()
    )

    data class Generationiv(
        @SerializedName("diamond-pearl")
        var diamondpearl: DiamondPearl? = DiamondPearl(),
        @SerializedName("heartgold-soulsilver")
        var heartgoldszsoulsilver: HeartgoldSoulsilver? = HeartgoldSoulsilver(),
        @SerializedName("platinum")
        var platinum: Platinum? = Platinum()
    )

    data class Generationiii(
        @SerializedName("emerald")
        var emerald: Emerald? = Emerald(),
        @SerializedName("firered-leafgreen")
        var fireredLeafgreen: FireredLeafgreen? = FireredLeafgreen(),
        @SerializedName("ruby-sapphire")
        var rubySapphire: RubySapphire? = RubySapphire()
    )


    data class Generationii(
        @SerializedName("crystal")
        var crystal: Crystal? = Crystal(),
        @SerializedName("gold")
        var gold: Gold? = Gold(),
        @SerializedName("silver")
        var silver: Silver? = Silver()
    )

    data class Generationi(
        @SerializedName("red-blue")
        var redBalue: RedBlue? = RedBlue(),
        @SerializedName("yellow")
        var yellow: Yellow? = Yellow()
    )

    data class Emerald(
        @SerializedName("front_default") var frontDefault: String? = null,
        @SerializedName("front_shiny") var frontShiny: String? = null
    )

    data class DiamondPearl(
        @SerializedName("back_default")
        var backDefault: String? = null,
        @SerializedName("back_female")
        var backFemale: String? = null,
        @SerializedName("back_shiny")
        var backShiny: String? = null,
        @SerializedName("back_shiny_female")
        var backShinyFemale: String? = null,
        @SerializedName("front_default")
        var frontDefault: String? = null,
        @SerializedName("front_female")
        var frontFemale: String? = null,
        @SerializedName("front_shiny")
        var frontShiny: String? = null,
        @SerializedName("front_shiny_female")
        var frontShinyFemale: String? = null
    )

    data class Crystal(
        @SerializedName("back_default") var backDefault: String? = null,
        @SerializedName("back_shiny") var backShiny: String? = null,
        @SerializedName("back_shiny_transparent") var backShinyTransparent: String? = null,
        @SerializedName("back_transparent") var backTransparent: String? = null,
        @SerializedName("front_default") var frontDefault: String? = null,
        @SerializedName("front_shiny") var frontShiny: String? = null,
        @SerializedName("front_shiny_transparent") var frontShinyTransparent: String? = null,
        @SerializedName("front_transparent") var frontTransparent: String? = null
    )

    data class Animated(
        @SerializedName("back_default") var backDefault: String? = null,
        @SerializedName("back_female") var backFemale: String? = null,
        @SerializedName("back_shiny") var backShiny: String? = null,
        @SerializedName("back_shiny_female") var backShinyFemale: String? = null,
        @SerializedName("front_default") var frontDefault: String? = null,
        @SerializedName("front_female") var frontFemale: String? = null,
        @SerializedName("front_shiny") var frontShiny: String? = null,
        @SerializedName("front_shiny_female") var frontShinyFemale: String? = null
    )


    data class FireredLeafgreen(
        @SerializedName("back_default")
        var backDefault: String? = null,
        @SerializedName("back_shiny")
        var backShiny: String? = null,
        @SerializedName("front_default")
        var frontDefault: String? = null,
        @SerializedName("front_shiny")
        var frontShiny: String? = null
    )

    data class BlackWhite(
        @SerializedName("animated")
        var animated: Animated? = Animated(),
        @SerializedName("back_default")
        var backDefault: String? = null,
        @SerializedName("back_female")
        var backFemale: String? = null,
        @SerializedName("back_shiny")
        var backShiny: String? = null,
        @SerializedName("back_shiny_female")
        var backShinyFemale: String? = null,
        @SerializedName("front_default")
        var frontDefault: String? = null,
        @SerializedName("front_female")
        var frontFemale: String? = null,
        @SerializedName("front_shiny")
        var frontShiny: String? = null,
        @SerializedName("front_shiny_female")
        var frontShinyFemale: String? = null
    )

}