stackTrace = Wscript.Arguments.Item(0)


Dim objMail
Set objMail = CreateObject("CDO.Message")


'Send the username email

objMail.From = "crashReport@coveredca.com"
objMail.To = "j.anaya.villagrana@accenture.com"
objMail.Subject = "Crash Report"
objMail.HTMLBody = "OPS something went wrong!<br><br><b><font color=red>EXCEPTION:</font></b><br>"& stackTrace &"</a>"

objMail.Configuration.Fields.Item("http://schemas.microsoft.com/cdo/configuration/sendusing") = 2
objMail.Configuration.Fields.Item("http://schemas.microsoft.com/cdo/configuration/smtpserver") = "sdc-inframail.calheers.local"
objMail.Configuration.Fields.Item("http://schemas.microsoft.com/cdo/configuration/smtpserverport") = 25
objMail.Configuration.Fields.Update

objMail.Send

Set objMail = Nothing

