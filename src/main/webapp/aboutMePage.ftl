<#import "templatePage.ftl" as page>
<#import "/spring.ftl" as spring>
<spring.bind path="roleList"/>

<@page.template>
<div class="container-fluid" style="text-align: center; font-size: larger">
    <div class="row">
        <#-- ROLE-->
        <div class="col-sm-2">
          <div class="thumbnail" STYLE="border: none;">
               <strong>Role :</strong>
          </div>
        </div>

        <div class="col-sm-2"">
            <div class="thumbnail">
                    cos
            </div>
        </div>

        <div class="col-sm-2">
            <div class="thumbnail" STYLE="border: none;">
                <strong> Change role : </strong>
            </div>
        </div>

        <div class="col-sm-2">
            <div class="thumbnail" STYLE="border: none;">
                <div class="dropdown">

                    <select class="form-control">
                         <#list roleList as role>
                             <option>${role.name}</option>
                        </#list>
                    </select>
                </div>
            </div>
        </div>


        <div class="col-sm-1">
            <div class="thumbnail" STYLE="border: none; color: green">
                <span class="glyphicon glyphicon-ok"></span>
            </div>
        </div>

</div>
</div>
</@page.template>
