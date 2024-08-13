variable "project_id" {
  description = "The ID of the Google Cloud project"
}

variable "region" {
  description = "The Google Cloud region"
  default     = "us-central1"
}

variable "service_account_email" {
  description = "The email of the service account"
}
