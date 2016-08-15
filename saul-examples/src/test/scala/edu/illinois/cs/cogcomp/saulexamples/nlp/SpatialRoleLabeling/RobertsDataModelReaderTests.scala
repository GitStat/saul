package edu.illinois.cs.cogcomp.saulexamples.nlp.SpatialRoleLabeling

import org.scalatest.{ FlatSpec, Matchers }

/** Created by taher on 8/14/16.
  */
class RobertsDataModelReaderTests extends FlatSpec with Matchers {
  val path = getResourcePath("SpRL/2012/")

  private def getResourcePath(relativePath: String): String =
    getClass.getClassLoader.getResource(relativePath).getPath

  import RobertsDataModel._

  PopulateSpRLDataModel(path, true, "2012", "Roberts")

  "Roberts Data Model Reader" should "Read data correctly." in {

    val sentenceList = sentences()
      .filterNot(x => x.getSentenceConstituent.getTextAnnotation.getId.startsWith("example.xml")).toList
    val relationList = relations().toList

    sentenceList.size should be(5)

    relationList.count(x => x.getSentence == sentenceList(0)) should be(32)

    relationList.count(x => x.getSentence == sentenceList(0) &&
      x.getLabel == RobertsRelation.RobertsRelationLabels.GOLD) should be(1)

    relationList.count(x => x.getSentence == sentenceList(1)) should be(16)

    relationList.count(x => x.getSentence == sentenceList(1) &&
      x.getLabel == RobertsRelation.RobertsRelationLabels.GOLD) should be(2)

    relationList.count(x => x.getSentence == sentenceList(2)) should be(18)

    relationList.count(x => x.getSentence == sentenceList(2) &&
      x.getLabel == RobertsRelation.RobertsRelationLabels.GOLD) should be(1)

    relationList.count(x => x.getSentence == sentenceList(3)) should be(32)

    relationList.count(x => x.getSentence == sentenceList(3) &&
      x.getLabel == RobertsRelation.RobertsRelationLabels.GOLD) should be(2)
  }

  "Roberts Data Model Features" should "be correct for examples of the paper." in {
    val examples = sentences()
      .filter(x => x.getSentenceConstituent.getTextAnnotation.getId.contains("example.xml")).toList
    val e1 = examples(0)
    val rels1 = relations().filter(x => x.getSentence == e1).toList
    val golds1 = rels1.filter(x => x.getLabel == RobertsRelation.RobertsRelationLabels.GOLD).toList
    val rel11 = golds1.head

    val e2 = examples(1)
    val rels2 = relations().filter(x => x.getSentence == e2).toList
    val golds2 = rels2.filter(x => x.getLabel == RobertsRelation.RobertsRelationLabels.GOLD).toList
    val rel21 = golds2.filter(x => x.getTrajector.getText == "bushes").head
    val rel22 = golds2.filter(x => x.getTrajector.getText == "trees").head

    rels1.size should be(18)
    rels2.size should be(9)

    golds1.size should be(1)
    golds2.size should be(2)

    BF1(rel11) should be("cars")
    BF1(rel21) should be("bushes")
    BF1(rel22) should be("trees")

    BF2(rel11) should be("house")
    BF2(rel21) should be("hill")
    BF2(rel22) should be("hill")

    BF3(rel11) should be("in_front_of")
    BF3(rel21) should be("on")
    BF3(rel22) should be("on")

    BF4(rel11) should be("car")
    BF4(rel21) should be("bush")
    BF4(rel22) should be("tree")

    BF5(rel11) should be("house")
    BF5(rel21) should be("hill")
    BF5(rel22) should be("hill")

    BF6(rel11) should be("↑NSUBJ↓PREP")
    BF6(rel21) should be("↓PREP")
    BF6(rel22) should be("↑CONJ↓PREP")

    BF7(rel11) should be("↓POBJ")
    BF7(rel21) should be("↓POBJ")
    BF7(rel22) should be("↓POBJ")

    JF2_1(rel11) should be("cars::in_front_of::house")
    JF2_1(rel21) should be("bushes::on::hill")
    JF2_1(rel22) should be("trees::on::hill")

    JF2_2(rel11) should be("false")
    JF2_2(rel21) should be("false")
    JF2_2(rel22) should be("false")

    JF2_3(rel11) should be("parked,the")
    JF2_3(rel21) should be("and,small,trees,the")
    JF2_3(rel22) should be("the")

    JF2_4(rel11) should be("in_front_of::↓POBJ")
    JF2_4(rel21) should be("on::↓POBJ")
    JF2_4(rel22) should be("on::↓POBJ")

    JF2_5(rel11) should be("cars")
    JF2_5(rel21) should be("bushes")
    JF2_5(rel22) should be("trees")

    JF2_6(rel11) should be("↓POBJ")
    JF2_6(rel21) should be("↓POBJ")
    JF2_6(rel22) should be("↓POBJ")

    JF2_7(rel11) should be("↑NSUBJ↓PREP::in_front_of")
    JF2_7(rel21) should be("↓PREP::on")
    JF2_7(rel22) should be("↑CONJ↓PREP::on")

    JF2_8(rel11) should startWith("hyp:dwelling,hyp:home,hyp:domicile,hyp:abode")
    JF2_8(rel21) should startWith("hyp:natural_elevation,hyp:elevation,hyp:structure")
    JF2_8(rel22) should startWith("hyp:natural_elevation,hyp:elevation,hyp:structure")

    JF2_9(rel11) should startWith("hyp:motor_vehicle,hyp:automotive_vehicle,hyp:wheeled_vehicle,hyp:compartment")
    JF2_9(rel21) should startWith("hyp:woody_plant,hyp:ligneous_plant,hyp:wilderness,hyp:wild,hyp:vegetation")
    JF2_9(rel22) should startWith("hyp:woody_plant,hyp:ligneous_plant,hyp:plane_figure,hyp:two-dimensional_figure")

    JF2_10(rel11) should be("TRAJECTOR_parked_INDICATOR_the_LANDMARK")
    JF2_10(rel21) should be("TRAJECTOR_and_small_trees_INDICATOR_the_LANDMARK")
    JF2_10(rel22) should be("TRAJECTOR_INDICATOR_the_LANDMARK")

    //    JF2_11(rel11) should be("")
    //    JF2_11(rel21) should be("")
    //    JF2_11(rel22) should be("")

    //    JF2_12(rel11) should be("")
    //    JF2_12(rel21) should be("")
    //    JF2_12(rel22) should be("")

    //    JF2_13(rel11) should be("")
    //    JF2_13(rel21) should be("")
    //    JF2_13(rel22) should be("")

    JF2_14(rel11) should be("car::in_front_of::house")
    JF2_14(rel21) should be("bush::on::hill")
    JF2_14(rel22) should be("tree::on::hill")

    //    JF2_15(rel11) should be("")
    //    JF2_15(rel21) should be("")
    //    JF2_15(rel22) should be("")

    BH1(rel11) should be("TRAJECTOR_INDICATOR_LANDMARK")
    BH1(rel21) should be("TRAJECTOR_INDICATOR_LANDMARK")
    BH1(rel22) should be("TRAJECTOR_INDICATOR_LANDMARK")

  }

}
