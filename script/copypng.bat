rem ���ݒ�
SET TEST_RESULT=C:\eclipse\workspaceDataforms3\dataforms3Tester\result
SET DOCUMENT=C:\eclipse\workspaceDataforms3\dataforms3\src\main\java\META-INF\resources\dataforms\doc
rem 2.1.devenv�ւ̃C���[�W�R�s�[

set INITPROJ=%TEST_RESULT%\jp.dataforms.fw.devtool.init.page.InitDevelopmentToolPage\InitDevelopmentToolForm\img
copy %INITPROJ%\initproj-001_000.png %DOCUMENT%\2.1.devenv
copy %INITPROJ%\initproj-003_000.png %DOCUMENT%\2.1.devenv

set INITDB=%TEST_RESULT%\jp.dataforms.fw.devtool.db.page.InitializeDatabasePage\DeveloperEditForm\img
copy %INITDB%\disp-001_000.png %DOCUMENT%\2.1.devenv\initdb-001-000.png
copy %INITDB%\save-002_002.png %DOCUMENT%\2.1.devenv\initdb-002_002.png

set LOGIN=%TEST_RESULT%\jp.dataforms.fw.app.login.page.LoginPage\LoginForm\img
copy %LOGIN%\login-001_001.png %DOCUMENT%\2.1.devenv\initdb-003_000.png

rem 2.2.devtool�ւ̃C���[�W�R�s�[
copy %LOGIN%\login-001_001.png %DOCUMENT%\2.2.devtool\sitemap.png

