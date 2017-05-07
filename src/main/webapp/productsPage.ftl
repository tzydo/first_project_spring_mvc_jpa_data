<#import "templatePage.ftl" as page>
<#import "/spring.ftl" as spring>

<@page.template>

    <div class="col-sm-10">
        <div class="container-fluid" style="margin-top: 50px;">

                                    <#-- ADD PRODUCT TYPE  -->
            <div class="row">
                <div class="col-sm-1"></div>

                <div class="col-sm-10" style="font-size: large;">
                    <div class="col-sm-4">
                       <strong>Add Product Type</strong>
                    </div>
                    <form action="addProductType"  role="form" method="post">
                        <div class="col-sm-4"><input type="text" name="newProductType"></div>
                        <div class="col-sm-2" STYLE="border: none;font-size: 20px; color: green">
                            <button type="submit" style="border: none; background-color: white;"  class="glyphicon                          glyphicon-ok icon-large"></button>
                        </div>
                    </form>
                </div>

                <div class="col-sm-1"></div>
            </div>



                                    <#-- ADD MARK  -->
            <div class="row">
                <div class="col-sm-1"></div>

                <div class="col-sm-10" style="font-size: large;">
                    <div class="col-sm-4">
                        <strong>Add Mark</strong>
                    </div>
                    <form action="addMark"  role="form" method="post">
                        <div class="col-sm-4"><input type="text" name="newMark"></div>
                        <div class="col-sm-2" STYLE="border: none;font-size: 20px; color: green">
                            <button type="submit" style="border: none; background-color: white;"  class="glyphicon                          glyphicon-ok icon-large"></button>
                        </div>
                    </form>
                </div>

                <div class="col-sm-1"></div>
            </div>



                                    <#-- ADD Model  -->
             <div class="row">
                 <div class="col-sm-1"></div>

                <div class="col-sm-10" style="font-size: large;">
                    <div class="col-sm-4">
                        <strong>Add Model</strong>
                    </div>
                 <form action="addModel"  role="form" method="post">
                    <div class="col-sm-4"><input type="text" name="newModel"></div>
                    <div class="col-sm-2" STYLE="border: none;font-size: 20px; color: green">
                        <button type="submit" style="border: none; background-color: white;"  class="glyphicon                          glyphicon-ok icon-large"></button>
                    </div>
                  </form>
                </div>

                <div class="col-sm-1"></div>
                </div>




                                    <#--SPACE-->
            <div class="space"></div>



                                    <#--REMOVE-->

                                    <#--REMOVE PRODUCT TYPE-->
            <div class="row">
                <div class="col-sm-1"></div>

                <div class="col-sm-10" style="font-size: large;">
                    <div class="col-sm-4">
                        <strong>Remove Product Type</strong>
                    </div>
                    <@spring.bind path="productTypeList"/>
                    <form action="removeProductType"  role="form" method="post" ">
                    <div class="col-sm-4">
                        <select class="selectpicker form-control" id="selectProductType" name="selectProductType">
                            <#list productTypeList as productType>
                                <option>${productType.name}</option>
                            </#list>
                        </select>
                    </div>
                    <div class="col-sm-2" STYLE="border: none;font-size: 20px; color: red">
                        <button type="submit" style="border: none; background-color: white;"  class="fa fa-times icon-large"></button>
                    </div>
                </div>
                </form>

                <div class="col-sm-1"></div>
            </div>



                                    <#--REMOVE MARK-->
            <div class="row">
                <div class="col-sm-1"></div>

                <div class="col-sm-10" style="font-size: large;">
                    <div class="col-sm-4">
                        <strong>Remove Mark</strong>
                    </div>
                    <@spring.bind path="markList"/>
                    <form action="removeMark"  role="form" method="post" ">
                        <div class="col-sm-4">
                            <select class="selectpicker form-control" id="selectMark" name="selectMark">
                                <#list markList as mark>
                                    <option>${mark.name}</option>
                                </#list>
                            </select>
                        </div>
                        <div class="col-sm-2" STYLE="border: none;font-size: 20px; color: red">
                            <button type="submit" style="border: none; background-color: white;"  class="                          fa fa-times icon-large"></button>
                        </div>
                    </div>
                </form>

                <div class="col-sm-1"></div>
            </div>



                                    <#--REMOVE MODEL-->
            <div class="row">
                <div class="col-sm-1"></div>

                <div class="col-sm-10" style="font-size: large;">
                    <div class="col-sm-4">
                        <strong>Remove model</strong>
                    </div>
                    <@spring.bind path="modellList"/>
                    <form action="removeModel"  role="form" method="post" ">
                    <div class="col-sm-4">
                        <select class="selectpicker form-control" id="selectModel" name="selectModel">
                            <#list modellList as model>
                                <option>${model.name}</option>
                            </#list>
                        </select>
                    </div>
                    <div class="col-sm-2" STYLE="border: none;font-size: 20px; color: red">
                        <button type="submit" style="border: none; background-color: white;"  class="fa fa-times icon-large"></button>
                    </div>
                </div>
                </form>

                <div class="col-sm-1"></div>
            </div>


            <style>
                .row{
                    padding: 5px;
                }

                .space{
                    margin-top: 50px;
                }
            </style>

        </div>
    </div>
</@page.template>