package bloczek.pl.enums

enum class Category(
    val title: String
) {
    T_SHIRTS("T-shirty") {
        override fun getSubcategories(): List<Subcategory> =
            listOf(Subcategory.HOODIE, Subcategory.CRAWNECK)
    },
    SWEATSHIRTS("Bluzy") {
        override fun getSubcategories(): List<Subcategory> {
            TODO("Not yet implemented")
        }
    },
    TROUSERS("Spodnie") {
        override fun getSubcategories(): List<Subcategory> {
            TODO("Not yet implemented")
        }
    },
    ACCESSORIES("Akcesoria"){
        override fun getSubcategories(): List<Subcategory> {
            TODO("Not yet implemented")
        }
    };

    abstract fun getSubcategories(): List<Subcategory>
}