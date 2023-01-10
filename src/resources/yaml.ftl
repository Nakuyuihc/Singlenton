permissions:
<#list permissionList as permission>
    - name: ${permission.name}
      key: ${permission.key}
      roles:
    <#list permission.roleList as role>
        - ${role}
    </#list>
</#list>